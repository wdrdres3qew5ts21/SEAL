Lilith's Throne
by Innoxia

Version 0.2.12

Compiled using Java version: jdk1.9.0_172

----------------------

HOW TO PLAY THIS GAME:

This game has only been tested on a Windows 7 operating system. I cannot guarantee that it will work on your system!

You will require the latest version of Java in order to play this game.
Java can be downloaded from here:
https://www.java.com/en/download/

More information about Java (if you're unsure what it is):
https://en.wikipedia.org/wiki/Java_(programming_language)

Once you've installed Java on your computer, simply double-click the file "LilithsThrone_0_2_12.jar" to start the game!

---------------------

IF YOU ARE ON WINDOWS AND ARE HAVING DIFFICULTY STARTING THE GAME:

I've packaged the game an an .exe, which can be downloaded from my blog: https://lilithsthrone.blogspot.co.uk/

If you're having difficulty, even after using the .exe, please leave me a message on my blog and I'll try to help!

----------------------

IMPORTANT:

Please read the disclaimer before playing the game.

----------------------

PATCH NOTES FOR v0.2.12

Artwork:
	Added FriendlyAlienFriend's Nyan artwork.
	Added Jam's Arthur artwork.
	
Contributors:
	Fixed a lot of typos, both in the code, as well as in-game dialogue. (#964 by Pimgd)

Items:
	Improved pencil skirt icon.
	Added 'feminine short sleeved shirt' as a replacement for Lilaya's unisex shirt. (Sold by Nyan.)

Other:
	<b>Reverted</b> currency display to the single 'flames' value. (It was a little too messy in many screens with the gold/silver/copper.)
	Newly summoned elementals now share many appearance values with their summoner, and additionally spawn with wings large enough for them to fly.
	Added 'pull down' displacements for skater, slip, and plunge dresses, where you shrug off the shoulder straps and pull the top down to reveal the chest area.
	Cargo trousers can now be equipped/removed over shoes.
	Slightly adjusted Lilaya's appearance, increasing her 'appears as' age to 32, her wing size from tiny to average, reduced her muscle from 'muscular' to 'lightly muscled', and fixed her legs to be human instead of demonic.
	Removed Lilaya's headband (as I thought it would be uncomfortable for her to wear with her horns), gave her a watch, and she now wears an unbuttoned lab coat while in her lab.
	Made minor changes to the prologue to reflect Lilaya's changes.
	Increased maximum width of the UI's centre pane from 1000px to 1200px.
	Increased starting money from 500 to 5000 flames.
	Added metallic colours to all makeup. Disabled glowing makeup in character creation.
	Added indication in transform menu that vagina cannot be transformed while pregnant.
	Removed the 25 energy cost of milking yourself in a milking room.
	Added options to pump fluids in slave's milking room into your vagina & anus. This can be used for self-insemination. There might be bugs if you remove your slave before self-impregnating with their cum.
	Footjobs can now be given/received even if the feet are covered. Foot names are replaced with the name of the clothing touching the target's penis.

Bugs:
	<b>Fixed</b> stored fluids in slave milking rooms not saving details about whose milk/cum/girlcum it was. <b>All saved fluids in slave milking rooms will be deleted when you load into this version</b> as a result of this fix, so please sell/drink all stored fluids before loading into this version.
	Fixed issue where you couldn't stop self actions if you were a submissive partner in some sex scenes.
	Fixed issue where after defeating an imp fortress's guards, you'd be unable to re-enter the fortress's 'entrance' tile.
	Fixed background error being thrown when slaves were having sex with one another while you were in an unrelated sex scene.
	Fixed clothing not being replaced after sex, but also added an option to turn on/off this behaviour in the content settings. (Clothing replacement is on by default.)
	Fixed issue in one of the fortress sex scenes where the imps were being treated as both participants and spectators.
	Fyrsia's groin is now correctly exposed at the start of the post-'brawler' scene's sex.
	Fixed money formatting to correctly display negative values.
	Fixed elemental perk tree's 'chill' perk applying +5/+5 ice damage/resistance instead of the intended +1/+1.
	Fixed issue with Jhortrax's post-sex 'Collapse' button sometimes not responding.
	Fixed issue where character imports would break if they were exported while in possession of a modded weapon that is no longer in your mods folder.
	Fixed issue with inventory management where sometimes clicking on clothing in the bottom-right of the game would cause major bugs. (Most noticeable in slavery management.) 
	Fixed parser errors in several of the 'generic NPC' dialogues.
	Fixed major bug where attacking sadists and masochists who had full lust would cause the game to crash.
	Fixed a bug where some special tease attacks would not work.
	Fixed major issue where maximum energy and aura never reflected increases & decreases from enchanted clothing being worn or potions being consumed. Also changed energy/aura gained from physique/arcane and levels to apply to the 'bonus' value.
	Fixed a cause of the issue where combat would keep repeating after beating Hyorlyss.
	Fixed major issues with all imp fortress parsing if you cleared them with an elemental as your main companion.
	Fixed a large amount of parsing errors in imp fortresses, mostly in the 'scare off' scenes after clearing the fortress through non-combat means.
	Fixed more parser errors in imp fortresses, which were related to pacifying the guards, then clearing the fortress.
	Imp fortress guards no longer respawn if the leader is already defeated.
	Fixed issue where imp gate and boss guards would not spawn in fortresses until you'd entered and left once already. (If you didn't do the enter/leave, it was causing numerous parsing and background logic errors.)
	Fixed some typos and grammatical errors.
	Fixed errors occurring if you didn't have a companion with you when you used the non-combat bypass options in Fyrsia's and Hyorlyss's fortresses.
	Elementals loaded in from versions prior to 0.2.11.9 will no longer have a non-elemental job perk. (Which was causing their physique to be 0.)
	Fixed combat loss sex scenes with Hyorlyss not working.
	Fixed issue with Hyorlyss's dominant sex scenes not starting if she couldn't get access to her groin.
	Jinxed clothing equips after imp fortress combat-defeat sex has been moved to be applied when you click to 'Continue', so that the jinxed effect isn't prematurely displayed.
	Lilaya will now correctly return to wearing her usual lab clothes after her geisha scenes.
	Fixed some issues with status effects while in the character creation.
	Fixed clothing mods that use the old equip/unequip description format having their equip/unequip text defaulting to the generic ones.
	Fixed Jhortrax only having 10 arcane. (He now has 35.)
	Fixed issue with the 'arcane cloud' spell not applying damage to targets who have the 'Desperate for sex' debuff.
	Fixed lust damage from masochist and sadist fetishes not taking into account lust resistance.
	Fixed 'seductive look' not being available for dominant partners in doggy style sex.
	Fixed being able to use the 'Spread legs' action in missionary when targeting someone other than the character between your legs. 
	Fixed incorrect display of slave's daily earnings when assigned to be milked.
	Fixed shop overflow dropping on the floor, which was caused by too many modded weapons/clothing being used. (Available items are randomly chosen to be stocked, so if you don't see some of your mods, try again the next day.)
	Fixed incorrect condom equip descriptions in sex.
	'Biojuice Canister' and 'Bubblegum Lollipop' items are now correctly marked as being transformative, meaning that they cannot be used on non-slave unique NPCs.
	Fixed quest clothing having enchantment postfixes automatically appended to the name.
	Fixed issue with quest clothing and weapons not being placed into quest inventory if regular inventory was full.
	Fixed another issue with masochist/sadist fetishes causing freezes in combat.
	Fixed issue with lust damage information not being appended correctly in combat.
	Fixed debug menu's transform options for legs/face/arms being limited.
	Fixed parsing error when using the 'True Nympho' option in Hyorlyss's fortress.
	
----------------------

DEFAULT KEYBOARD SHORTCUTS:

ESC Options menu

F5 Quicksave
F9 Quickload

I Inventory
J or P Phone menu
C Characters present
Z Zoom map

W Move North
A Move West
S Move South
D Move East

0-9 Quick select response
Q Previous response page
E Next response page

You can customise these shortcuts from within the game's options menu.

----------------------

BLOG LINK:

https://lilithsthrone.blogspot.co.uk/

----------------------

"THEY ACTUALLY READ THE README" BONUS!

The debug code is "buggy". Just type that into the game at any point to bring up the debug menu! ^^

----------------------