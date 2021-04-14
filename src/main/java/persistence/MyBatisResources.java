package persistence;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.cdi.SessionFactoryProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;
import java.io.InputStream;

//ORM - nežinom kaip jis veiks esant didesniam duomenų kiekiui (nes yra automatiškai generuojamos užklausos) (Jeigu nėra didelio poreikio apdoroti daug duomenų vienu metu)
//Daro daugiau magijos, reikia mažiau rūpintis kaip viskas veikia, bet sunku pasitikėt kada suveiks.

//DataMapper - pilna kontrolė SQL lygyje (Jeigu dirbam su didžiuliais duomenų kiekis ir reikalinga kiekviena sekundė)
//DataMapper MyBatis palaiko ir dinaminį SQL


@ApplicationScoped
public class MyBatisResources {

    @Produces
    @ApplicationScoped
    @SessionFactoryProvider
    private SqlSessionFactory produceSqlSessionFactory() {
        try {
            String resource = "MyBatisConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            return sqlSessionFactory;
//            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("MyBatisConfig.xml"));
        } catch (IOException e) {
            throw new RuntimeException("MyBatisResources.produceSqlSessionFactory():", e);
        }
    }
}