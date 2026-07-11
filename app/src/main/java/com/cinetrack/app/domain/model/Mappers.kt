package com.cinetrack.app.domain.model

import com.cinetrack.app.data.api.dto.MovieDetailDto
import com.cinetrack.app.data.api.dto.MovieDto
import com.cinetrack.app.data.local.entity.FavoriteEntity
import com.cinetrack.app.data.local.entity.WatchlistEntity
import com.cinetrack.app.data.api.dto.TvShowDto
import com.cinetrack.app.data.api.dto.TvShowDetailDto

fun MovieDto.toDomain(): Movie = Movie(
    id = id, title = title, originalTitle = originalTitle,
    overview = overview, posterPath = posterPath, backdropPath = backdropPath,
    releaseDate = releaseDate, voteAverage = voteAverage, voteCount = voteCount,
    popularity = popularity, genreIds = genreIds ?: emptyList()
)

fun MovieDetailDto.toDomain(): MovieDetail = MovieDetail(
    id = id, title = title, originalTitle = originalTitle,
    overview = overview, posterPath = posterPath, backdropPath = backdropPath,
    releaseDate = releaseDate, voteAverage = voteAverage, voteCount = voteCount,
    popularity = popularity, runtime = runtime, tagline = tagline, status = status,
    genres = genres?.map { Genre(it.id, it.name) } ?: emptyList(),
    cast = credits?.cast?.sortedBy { it.order }?.take(20)?.map {
        CastMember(it.id, it.name, it.character, it.profilePath, it.order)
    } ?: emptyList(),
    director = credits?.crew?.firstOrNull { it.job == "Director" }?.name,
    videos = videos?.results?.map {
        Video(it.id ?: "", it.name, it.key, it.site, it.type, it.official)
    } ?: emptyList(),
    similarMovies = similar?.results?.map { it.toDomain() } ?: emptyList(),
    watchProviders = watchProviders?.results?.get("IT")?.let { country ->
        WatchProviderInfo(
            link = country.link,
            streaming = country.flatrate?.map { WatchProvider(it.providerId, it.providerName, it.logoPath) } ?: emptyList(),
            rent = country.rent?.map { WatchProvider(it.providerId, it.providerName, it.logoPath) } ?: emptyList(),
            buy = country.buy?.map { WatchProvider(it.providerId, it.providerName, it.logoPath) } ?: emptyList()
        )
    }
)

fun WatchlistEntity.toDomain(): WatchlistItem = WatchlistItem(
    movieId = movieId, title = title, posterPath = posterPath,
    voteAverage = voteAverage, releaseDate = releaseDate, overview = overview,
    addedAt = addedAt, isWatched = isWatched
)

fun Movie.toWatchlistEntity(): WatchlistEntity = WatchlistEntity(
    movieId = id, title = title, posterPath = posterPath,
    voteAverage = voteAverage, releaseDate = releaseDate, overview = overview
)

fun Movie.toFavoriteEntity(): FavoriteEntity = FavoriteEntity(
    movieId = id, title = title, posterPath = posterPath,
    voteAverage = voteAverage, releaseDate = releaseDate
)

fun MovieDetail.toWatchlistEntity(): WatchlistEntity = WatchlistEntity(
    movieId = id, title = title, posterPath = posterPath,
    voteAverage = voteAverage, releaseDate = releaseDate, overview = overview
)

fun MovieDetail.toFavoriteEntity(): FavoriteEntity = FavoriteEntity(
    movieId = id, title = title, posterPath = posterPath,
    voteAverage = voteAverage, releaseDate = releaseDate
)

fun TvShowDto.toDomain(): TvShow = TvShow(
    id = id, name = name, originalName = originalName,
    overview = overview, posterPath = posterPath, backdropPath = backdropPath,
    firstAirDate = firstAirDate, voteAverage = voteAverage, voteCount = voteCount,
    popularity = popularity, genreIds = genreIds ?: emptyList()
)

fun TvShowDetailDto.toDomain(): TvShowDetail = TvShowDetail(
    id = id, name = name, originalName = originalName,
    overview = overview, posterPath = posterPath, backdropPath = backdropPath,
    firstAirDate = firstAirDate, voteAverage = voteAverage, voteCount = voteCount,
    popularity = popularity, numberOfSeasons = numberOfSeasons, numberOfEpisodes = numberOfEpisodes,
    tagline = tagline, status = status,
    genres = genres?.map { Genre(it.id, it.name) } ?: emptyList(),
    cast = credits?.cast?.sortedBy { it.order }?.take(20)?.map {
        CastMember(it.id, it.name, it.character, it.profilePath, it.order)
    } ?: emptyList(),
    videos = videos?.results?.map {
        Video(it.id ?: "", it.name, it.key, it.site, it.type, it.official)
    } ?: emptyList(),
    similarShows = similar?.results?.map { it.toDomain() } ?: emptyList(),
    watchProviders = watchProviders?.results?.get("IT")?.let { country ->
        WatchProviderInfo(
            link = country.link,
            streaming = country.flatrate?.map { WatchProvider(it.providerId, it.providerName, it.logoPath) } ?: emptyList(),
            rent = country.rent?.map { WatchProvider(it.providerId, it.providerName, it.logoPath) } ?: emptyList(),
            buy = country.buy?.map { WatchProvider(it.providerId, it.providerName, it.logoPath) } ?: emptyList()
        )
    }
)