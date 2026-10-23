package codingdojo.exampleD

import kotlinx.serialization.Serializable

@Serializable
data class ItemsList(val items: List<Item>)
