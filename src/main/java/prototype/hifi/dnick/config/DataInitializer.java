package prototype.hifi.dnick.config;

import org.springframework.stereotype.Component;
import prototype.hifi.dnick.model.Topic;
import prototype.hifi.dnick.repository.TopicRepository;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final TopicRepository topicRepository;

    public DataInitializer(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @PostConstruct
    public void initData() {
        Topic izgorenici=new Topic("Izgorenici","Изгореници","https://www.youtube.com/watch?v=r7clpp4eyY0","Фрактура на коска или скршеница на коска е медицинска состојба каде постои прекин во континуитетот на коската. Фрактурата може да биде резултат на дејството на јака сила или оптоварување врз коската, или резултат на дејството на мала сила доколку структурата на коската е ослабена од други медицински состојби како остеопороза, тумори, osteogenesis imperfecta (во овие случаи фрактурата се именува како патолошка фрактура).Болката е доминантен симптом. И покрај тоа што самото коскено ткиво не содржи ноцицептори, скршениците се болни заради неколку причини:\n" +
                "\n" +
                "Прекин во континуитетот на периостеумот со или без прекин на ендостеумот кои имаат ноцицептори.\n" +
                "Отокот на околните меки ткива настанат од крварењето од оштетените периостални крвни садови прави болка поради притисок.\n" +
                "Мускулните спазми кои тежнеат да ги задржат фрагментите на место.\n" +
                "Деформитетот, принудната положба на делот од телото, патолошката подвижност и крцкањето на фрагментите при движење се исто така дел од клиничката слика.\n" +
                "\n" +
                "Оштетувањето на околните нерви или крвни садови, ’рбтениот мозок и нервните корени (кај фрактури на ’рбет), черепната содржина (кај фрактури на череп) можат да предизвикаат други специфични знаци и симптоми.");
        topicRepository.save(izgorenici);
    }
}