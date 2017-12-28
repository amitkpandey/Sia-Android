/*
 * Copyright (c) 2017 Nicholas van Dyke. All rights reserved.
 */

package vandyke.siamobile.data.models.consensus

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import vandyke.siamobile.util.SCUtil
import java.math.BigDecimal

@Entity(tableName = "consensus")
@JsonIgnoreProperties(ignoreUnknown = true)
data class ConsensusData @JsonCreator constructor(
        @JsonProperty(value = "synced")
        val synced: Boolean,
        @JsonProperty(value = "height")
        val height: Int,
        @JsonProperty(value = "currentblock")
        val currentBlock: String,
        @JsonProperty(value = "difficulty")
        val difficulty: BigDecimal) {

    @PrimaryKey
    var timestamp = System.currentTimeMillis()
    var syncProgress: Double = height.toDouble() / SCUtil.estimatedBlockHeightAt(System.currentTimeMillis() / 1000) * 100
}