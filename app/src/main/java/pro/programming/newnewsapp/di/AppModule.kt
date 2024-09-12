package pro.programming.newnewsapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.programming.newnewsapp.data.local.NewsDao
import pro.programming.newnewsapp.data.local.NewsDatabase
import pro.programming.newnewsapp.data.local.NewsTypeConvertor
import pro.programming.newnewsapp.data.manager.LocalUserManagerImpl
import pro.programming.newnewsapp.data.remote.NewsApi
import pro.programming.newnewsapp.data.repository.NewsRepositoryImpl
import pro.programming.newnewsapp.domain.manager.LocalUserManager
import pro.programming.newnewsapp.domain.repository.NewsRepository
import pro.programming.newnewsapp.domain.usecases.app_entry.AppEntryUseCases
import pro.programming.newnewsapp.domain.usecases.app_entry.ReadAppEntry
import pro.programming.newnewsapp.domain.usecases.app_entry.SaveAppEntry
import pro.programming.newnewsapp.domain.usecases.news.DeleteArticle
import pro.programming.newnewsapp.domain.usecases.news.GetNews
import pro.programming.newnewsapp.domain.usecases.news.NewsUseCases
import pro.programming.newnewsapp.domain.usecases.news.SearchNews
import pro.programming.newnewsapp.domain.usecases.news.SelectArticle
import pro.programming.newnewsapp.domain.usecases.news.SelectArticles
import pro.programming.newnewsapp.domain.usecases.news.UpsertArticle
import pro.programming.newnewsapp.util.Constants.BASE_URL
import pro.programming.newnewsapp.util.Constants.NEWS_DATABASE_NAME
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        dao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi = newsApi, newsDao = dao)


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        dao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository = newsRepository),
            searchNews = SearchNews(newsRepository = newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}