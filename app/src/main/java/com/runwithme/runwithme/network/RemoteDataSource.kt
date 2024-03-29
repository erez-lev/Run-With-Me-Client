package com.runwithme.runwithme.network

import com.runwithme.runwithme.model.*
import com.runwithme.runwithme.model.network.*
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val runWithMeApi: RunWithMeService
) {
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return runWithMeApi.login(loginRequest)
    }

    suspend fun signup(signupRequest: SignupRequest): Response<LoginResponse> {
        return runWithMeApi.signup(signupRequest)
    }

    suspend fun isValidToken(token:String) : Response<TokenResponse>{
        return runWithMeApi.isValidToken(token)
    }

    suspend fun updateMe(user:User) : Response<User> {
        return runWithMeApi.updateMe(user)
    }

    suspend fun getAllUsers() : Response<AllUsersResponse>{
        return runWithMeApi.getAllUsers()
    }

    suspend fun getAllFriends() : Response<MyFriendsResponse>{
        return runWithMeApi.getAllFriends()
    }

    suspend fun getMyGroups() : Response<MyGroupsResponse>{
        return runWithMeApi.getMyGroups()
    }

    suspend fun getMyRuns() : Response<MyRunsResponse>{
        return runWithMeApi.getMyRuns()
    }

    suspend fun getMyTodayGroupRuns() : Response<MyTodayGroupRunsResponse>{
        return runWithMeApi.getMyTodayGroupRuns()
    }

    suspend fun addFriend(friendID : String) : Response<User>{
        return runWithMeApi.addFriend(friendID)
    }

    suspend fun deleteFriend(friendID : String) : Response<User>{
        return runWithMeApi.deleteFriend(friendID)
    }

    suspend fun saveRunData(runDataRequest: RunDataRequest): Response<SaveRunResponse> {
        return runWithMeApi.saveRunData(runDataRequest)
    }

    suspend fun saveGroupData(groupDataRequest: GroupDataRequest): Response<Group> {
        return runWithMeApi.saveGroupData(groupDataRequest)
    }

    suspend fun saveScheduleRun(scheduleRunRequest: ScheduleRunRequest): Response<ScheduleRunResponse> {
        return runWithMeApi.saveScheduleRun(scheduleRunRequest)
    }

    suspend fun getFutureGroupRuns(groupId:String): Response<FutureGroupRunResponse> {
        return runWithMeApi.getFutureGroupRuns(groupId)
    }

    suspend fun getPastGroupRuns(groupId:String): Response<PastGroupRunResponse> {
        return runWithMeApi.getPastGroupRuns(groupId)
    }
}