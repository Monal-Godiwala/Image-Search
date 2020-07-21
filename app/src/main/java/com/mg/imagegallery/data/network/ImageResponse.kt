package com.mg.imagegallery.data.network


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImageResponse(
    @SerializedName("data")
    var `data`: List<Data?>?,
    @SerializedName("status")
    var status: Int?,
    @SerializedName("success")
    var success: Boolean?
) : Serializable {
    data class Data(
        @SerializedName("account_id")
        var accountId: Int?,
        @SerializedName("account_url")
        var accountUrl: String?,
        @SerializedName("ad_config")
        var adConfig: AdConfig?,
        @SerializedName("ad_type")
        var adType: Int?,
        @SerializedName("ad_url")
        var adUrl: String?,
        @SerializedName("animated")
        var animated: Boolean?,
        @SerializedName("bandwidth")
        var bandwidth: Long?,
        @SerializedName("comment_count")
        var commentCount: Int?,
        @SerializedName("cover")
        var cover: String?,
        @SerializedName("cover_height")
        var coverHeight: Int?,
        @SerializedName("cover_width")
        var coverWidth: Int?,
        @SerializedName("datetime")
        var datetime: Int?,
        @SerializedName("description")
        var description: Any?,
        @SerializedName("downs")
        var downs: Int?,
        @SerializedName("edited")
        var edited: Int?,
        @SerializedName("favorite")
        var favorite: Boolean?,
        @SerializedName("favorite_count")
        var favoriteCount: Int?,
        @SerializedName("gifv")
        var gifv: String?,
        @SerializedName("has_sound")
        var hasSound: Boolean?,
        @SerializedName("height")
        var height: Int?,
        @SerializedName("hls")
        var hls: String?,
        @SerializedName("id")
        var id: String?,
        @SerializedName("images")
        var images: List<Image?>?,
        @SerializedName("images_count")
        var imagesCount: Int?,
        @SerializedName("in_gallery")
        var inGallery: Boolean?,
        @SerializedName("in_most_viral")
        var inMostViral: Boolean?,
        @SerializedName("include_album_ads")
        var includeAlbumAds: Boolean?,
        @SerializedName("is_ad")
        var isAd: Boolean?,
        @SerializedName("is_album")
        var isAlbum: Boolean?,
        @SerializedName("layout")
        var layout: String?,
        @SerializedName("link")
        var link: String?,
        @SerializedName("looping")
        var looping: Boolean?,
        @SerializedName("mp4")
        var mp4: String?,
        @SerializedName("mp4_size")
        var mp4Size: Int?,
        @SerializedName("nsfw")
        var nsfw: Boolean?,
        @SerializedName("points")
        var points: Int?,
        @SerializedName("privacy")
        var privacy: String?,
        @SerializedName("processing")
        var processing: Processing?,
        @SerializedName("score")
        var score: Int?,
        @SerializedName("section")
        var section: String?,
        @SerializedName("size")
        var size: Int?,
        @SerializedName("tags")
        var tags: List<Tag?>?,
        @SerializedName("title")
        var title: String?,
        @SerializedName("topic")
        var topic: String?,
        @SerializedName("topic_id")
        var topicId: Int?,
        @SerializedName("type")
        var type: String?,
        @SerializedName("ups")
        var ups: Int?,
        @SerializedName("views")
        var views: Int?,
        @SerializedName("vote")
        var vote: Any?,
        @SerializedName("width")
        var width: Int?
    ) : Serializable {

        data class AdConfig(
            @SerializedName("highRiskFlags")
            var highRiskFlags: List<Any?>?,
            @SerializedName("safeFlags")
            var safeFlags: List<String?>?,
            @SerializedName("showsAds")
            var showsAds: Boolean?,
            @SerializedName("unsafeFlags")
            var unsafeFlags: List<String?>?,
            @SerializedName("wallUnsafeFlags")
            var wallUnsafeFlags: List<Any?>?
        ) : Serializable

        data class Image(
            @SerializedName("account_id")
            var accountId: Any?,
            @SerializedName("account_url")
            var accountUrl: Any?,
            @SerializedName("ad_type")
            var adType: Int?,
            @SerializedName("ad_url")
            var adUrl: String?,
            @SerializedName("animated")
            var animated: Boolean?,
            @SerializedName("bandwidth")
            var bandwidth: Long?,
            @SerializedName("comment_count")
            var commentCount: Any?,
            @SerializedName("datetime")
            var datetime: Int?,
            @SerializedName("description")
            var description: Any?,
            @SerializedName("downs")
            var downs: Any?,
            @SerializedName("edited")
            var edited: String?,
            @SerializedName("favorite")
            var favorite: Boolean?,
            @SerializedName("favorite_count")
            var favoriteCount: Any?,
            @SerializedName("gifv")
            var gifv: String?,
            @SerializedName("has_sound")
            var hasSound: Boolean?,
            @SerializedName("height")
            var height: Int?,
            @SerializedName("hls")
            var hls: String?,
            @SerializedName("id")
            var id: String?,
            @SerializedName("in_gallery")
            var inGallery: Boolean?,
            @SerializedName("in_most_viral")
            var inMostViral: Boolean?,
            @SerializedName("is_ad")
            var isAd: Boolean?,
            @SerializedName("link")
            var link: String?,
            @SerializedName("looping")
            var looping: Boolean?,
            @SerializedName("mp4")
            var mp4: String?,
            @SerializedName("mp4_size")
            var mp4Size: Int?,
            @SerializedName("nsfw")
            var nsfw: Any?,
            @SerializedName("points")
            var points: Any?,
            @SerializedName("processing")
            var processing: Processing?,
            @SerializedName("score")
            var score: Any?,
            @SerializedName("section")
            var section: Any?,
            @SerializedName("size")
            var size: Int?,
            @SerializedName("tags")
            var tags: List<Any?>?,
            @SerializedName("title")
            var title: Any?,
            @SerializedName("type")
            var type: String?,
            @SerializedName("ups")
            var ups: Any?,
            @SerializedName("views")
            var views: Int?,
            @SerializedName("vote")
            var vote: Any?,
            @SerializedName("width")
            var width: Int?
        ) : Serializable {
            data class Processing(
                @SerializedName("status")
                var status: String?
            ) : Serializable
        }

        data class Processing(
            @SerializedName("status")
            var status: String?
        ) : Serializable

        data class Tag(
            @SerializedName("accent")
            var accent: String?,
            @SerializedName("background_hash")
            var backgroundHash: String?,
            @SerializedName("background_is_animated")
            var backgroundIsAnimated: Boolean?,
            @SerializedName("description")
            var description: String?,
            @SerializedName("description_annotations")
            var descriptionAnnotations: DescriptionAnnotations?,
            @SerializedName("display_name")
            var displayName: String?,
            @SerializedName("followers")
            var followers: Int?,
            @SerializedName("following")
            var following: Boolean?,
            @SerializedName("is_promoted")
            var isPromoted: Boolean?,
            @SerializedName("is_whitelisted")
            var isWhitelisted: Boolean?,
            @SerializedName("logo_destination_url")
            var logoDestinationUrl: Any?,
            @SerializedName("logo_hash")
            var logoHash: Any?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("thumbnail_hash")
            var thumbnailHash: Any?,
            @SerializedName("thumbnail_is_animated")
            var thumbnailIsAnimated: Boolean?,
            @SerializedName("total_items")
            var totalItems: Int?
        ) : Serializable {
            class DescriptionAnnotations : Serializable
        }
    }
}