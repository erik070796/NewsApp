package pro.programming.newnewsapp.domain.usecases.app_entry

import pro.programming.newnewsapp.domain.manager.LocalUserManager


class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}