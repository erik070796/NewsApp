package pro.programming.newnewsapp.domain.usecases.app_entry

import kotlinx.coroutines.flow.Flow
import pro.programming.newnewsapp.domain.manager.LocalUserManager


class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}