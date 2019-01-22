-ignorewarnings
-keep class * {
    public private *;
}
-dontwarn lombok.NonNull
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}
-dontnote rx.internal.util.PlatformDependent
-dontwarn java.lang.invoke.*
-dontwarn **$$Lambda$*
-dontnote retrofit2.Platform
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-dontwarn okio.**
-keepclassmembers class **.R$* {
    public static <fields>;
}
-keep class eu.electronicid.sdk.video.contract.** { *; }
-keep class eu.electronicid.demo.videoiddemo.dto.** { *; }
-keep class eu.electronicid.demo.videoiddemo.ui.list.Item { *; }
-dontwarn eu.electronicid.demo.videoiddemo.ui.list.**
-dontwarn eu.electronicid.demo.videoiddemo.dto.**
-dontwarn eu.electronicid.demo.videoiddemo.network.**
-keep class org.webrtc.** { *; }