package seal.UserService.Favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seal.UserService.User.User;
import seal.UserService.User.UserRepository;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Favorite> getFavoriteByUserId(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

    public Favorite createFavorite(Long userId, Favorite favorite) {
        User user = userRepository.findById(userId).get();
        favorite.setUser(user);
        favorite.setIsSomeThingUpdate(true);
        return favoriteRepository.save(favorite);
    }

    public Favorite deleteFavoriteById(Long userId, Long id) {
        User user = userRepository.findById(userId).get();
        Favorite favorite_object = favoriteRepository.findById(id).get();
        favorite_object.setUser(user);
        favoriteRepository.delete(favorite_object);
        return favorite_object;
    }

    public Favorite userReadNotification(Long userId, Favorite favorite) {
        User user = userRepository.findById(userId).get();
        favorite = favoriteRepository.findById(favorite.getId()).get();
        favorite.setIsSomeThingUpdate(false);
        System.out.println("Update New : " + user);
        System.out.println("Favourite : " + favorite);
        return  favoriteRepository.save(favorite);
    }

    public List<Favorite> subjectFileHadBeenUpdateByTeacher(int subjectId) {
        List<Favorite> subjectLists = favoriteRepository.findBySubjectId(subjectId + "");
        for (int i = 0; i < subjectLists.size(); i++) {
            subjectLists.get(i).setIsSomeThingUpdate(true);
        }
        favoriteRepository.saveAll(subjectLists);
        return subjectLists;
    }
}
