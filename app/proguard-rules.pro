# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

-ignorewarnings
-keep class * {
    public private *;
}

# ignore lombok warning
-dontwarn lombok.NonNull

# rxjava
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


# Proguard fails with lambdas #55
# https://github.com/evant/gradle-retrolambda/issues/55
-dontwarn java.lang.invoke.*
-dontwarn **$$Lambda$*

# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform

# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8

# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature

# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

-dontwarn okio.**
-keepclassmembers class **.R$* {
    public static <fields>;
}

# VideoID
-keep class eu.electronicid.sdk.videoid.contract.** { *; }

# WebRTC library
-keep class org.webrtc.** { *; }