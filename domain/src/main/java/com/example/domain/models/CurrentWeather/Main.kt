package com.example.domain.models.CurrentWeather

/*data class Main(
    val temp: String


)*/

data class Main(
    val temp: Double,
    //@JsonProperty("feels_like")
    val feels_like: Double,
    //@JsonProperty("temp_min")
    val temp_min: Double,
    //@JsonProperty("temp_max")
    val temp_max: Double,
    val pressure: Long,
    val humidity: Long,
    // @JsonProperty("sea_level")
    val sea_level: Long,
    //@JsonProperty("grnd_level")
    val grnd_level: Long,
)