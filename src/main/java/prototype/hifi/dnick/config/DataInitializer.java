package prototype.hifi.dnick.config;

import org.springframework.stereotype.Component;
import prototype.hifi.dnick.model.Badge;
import prototype.hifi.dnick.model.Topic;
import prototype.hifi.dnick.model.enumerations.Badges;
import prototype.hifi.dnick.model.enumerations.Role;
import prototype.hifi.dnick.repository.BadgeRepository;
import prototype.hifi.dnick.repository.TopicRepository;
import prototype.hifi.dnick.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final TopicRepository topicRepository;
    private final UserService userService;
    private final BadgeRepository badgeRepository;

    public DataInitializer(TopicRepository topicRepository, UserService userService, BadgeRepository badgeRepository) {
        this.topicRepository = topicRepository;
        this.userService = userService;
        this.badgeRepository = badgeRepository;
    }

    @PostConstruct
    public void initData() {
        Topic skrshenici=new Topic("Skrshenici","Скршеници","./images/broken_bone.JPG", "https://www.youtube.com/embed/bqJNshguoTY", "/pdf/скршеници.pdf");
        Topic izgorenici=new Topic("Izgorenici","Изгореници", "./images/burns.JPG","https://www.youtube.com/embed/IOtnGl_9-qw", "/pdf/изгореници.pdf");
        Topic krvarenje=new Topic("Krvarenje","Крварење", "./images/bleeding.JPG","https://www.youtube.com/embed/BYQzwqrEUlU","/pdf/крварење.pdf");
        Topic srcevoBelodrobno=new Topic("SrcevoBelodrobnoOzivuvanje","Срцево Белодробно оживување","./images/heart_lungs.JPG","https://www.youtube.com/embed/hHyVQiWFXzg","/pdf/срцево-белодробно-оживување.pdf");
        Topic zadusuvanje=new Topic("Zadushuvanje","Задушување","./images/choking.JPG","https://www.youtube.com/embed/6E9AXXRdkfE","/pdf/задушување.pdf");
        Topic mozocenUdar=new Topic("MozocenUdar","Мозочен удар","./images/stroke.JPG","https://www.youtube.com/embed/PCNTMIcOMpE","/pdf/мозочен-удар.pdf");
        Topic srcevUdar=new Topic("SrcevUdar","Срцев удар", "./images/heart_attack.JPG","https://www.youtube.com/embed/1qje-XlNowI","/pdf/срцев-удар.pdf");
        Topic smrznuvanje=new Topic("Smrznuvanje","Смрзнување","./images/hypothermia.JPG","https://www.youtube.com/embed/qlNKCSC2s5w","/pdf/смрзнување.pdf");


        topicRepository.save(krvarenje);
        topicRepository.save(skrshenici);
        topicRepository.save(zadusuvanje);
        topicRepository.save(srcevoBelodrobno);
        topicRepository.save(srcevUdar);
        topicRepository.save(mozocenUdar);
        topicRepository.save(izgorenici);
        topicRepository.save(smrznuvanje);


        Badge tests1=new Badge(Badges.TESTS_1,"Направи 1 тест!");
        Badge tests3=new Badge(Badges.TESTS_3,"Направи 3 тестови!");
        Badge tests5=new Badge(Badges.TESTS_5,"Направи 5 тестови!");
        Badge pointsOver90=new Badge(Badges.SCORE_OVER_90,"Освој над 90 поени!");
        Badge points100=new Badge(Badges.SCORE_100,"Освој 100 поени!");

        badgeRepository.save(tests1);
        badgeRepository.save(tests3);
        badgeRepository.save(tests5);
        badgeRepository.save(pointsOver90);
        badgeRepository.save(points100);


        userService.register("test","test","test","test","test", Role.ROLE_USER);
    }
}