package devsy.toy.leveldb

import org.iq80.leveldb.DB
import org.iq80.leveldb.Options
import org.iq80.leveldb.impl.Iq80DBFactory.factory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
class LevelDBConfiguartion {

    @Bean
    fun levelDB(): DB {
        val options = Options().apply {
            createIfMissing(true)
        }
        val dbFile = File("leveldb")
        if(!dbFile.exists())
            dbFile.mkdir()
        return factory.open(dbFile, options)
    }
}