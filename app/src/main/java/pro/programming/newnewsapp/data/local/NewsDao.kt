package pro.programming.newnewsapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow
import pro.programming.newnewsapp.domain.model.Article
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM Article")
    fun  getArticles():Flow<List<Article>>
    
    @Query("SELECT * FROM Article Where url=:url")
    fun  getArticles1(url:String):Article?


}