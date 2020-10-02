package com.cammace.rothko.core.data

import TrendingArtworkQuery
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.cammace.rothko.core.data.model.TrendingArtwork
import com.cammace.rothko.core.results.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Separates the data sources and where data is fetched from the UI layer.
 */
@Singleton
class ArtworkRepository @Inject constructor(
    private val apolloClient: ApolloClient
) {

    suspend fun getTrendingArtwork(): Flow<Resource<List<TrendingArtwork>>> = flow {
        emit(Resource.loading(null))
        try {
            val response = apolloClient.query(TrendingArtworkQuery()).await()
            emit(Resource.success(response.toTrendingArtwork()))
        } catch (exception: ApolloException) {
            Timber.e(exception, "Failed to fetch trending artwork.")
            emit(Resource.error(null))
        }
    }
}

fun Response<TrendingArtworkQuery.Data>.toTrendingArtwork(): List<TrendingArtwork> {
    return data?.marketingCollection?.filteredArtwork?.edges?.mapNotNull {
        it?.node?.let { node ->
            TrendingArtwork(
                imageUrl = node.image?.url,
                title = node.title,
                artist = node.artists?.get(0)?.name
            )
        }
    } ?: emptyList()
}

