package seal.VideoService;

@RunWith(MockitoJUnitRunner.class)
public class VideoServiceTest{

    @Mock
    private VideoAdapter videoAdapter;

    @Before
    public void setUp() throws Exception {
        VideoAdapter = new VideoAdapter(videoAdapter);
    }

    @Test
    public void testFindVideoById() throws Exception{
        Video video = new Video();
        video.setId("1");
        entityManager.persist(video);

        Optional<Video> videoOptional = videoAdapter.findVideoById("1");

        assertThat(videoOptional.get().getId()).isEqualTo("1");
    }


}