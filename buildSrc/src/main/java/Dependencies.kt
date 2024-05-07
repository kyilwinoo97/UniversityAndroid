object Dependencies {

    val coreKtx by lazy {"androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy {"androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy {"com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy {"androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val junit by lazy {"junit:junit:${Versions.junit}" }
    val extJunit by lazy {"androidx.test.ext:junit:${Versions.extJunit}" }
    val espressoCore by lazy {"androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val multiDex by lazy { "androidx.multidex:multidex:${Versions.multidex}" }

    //coroutine
    val coroutineAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}" }
    val coroutineCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}" }

    //room
    val roomRuntime by lazy{"androidx.room:room-runtime:${Versions.roomDb}"}
    val roomCompiler by lazy{"androidx.room:room-compiler:${Versions.roomDb}"}
    val roomKtx by lazy{"androidx.room:room-ktx:${Versions.roomDb}"}

    //lifecycle
    val lifeCycleRuntimeCompose by lazy { "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycle}" }
    val lifeCycleViewmodelCompose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}" }
    val lifeCycleExtensions by lazy {  "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExt}"}

    //retrofit
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val gson by lazy { "com.google.code.gson:gson:retrofit_version${Versions.retrofit}" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"}
    val okhttp by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}" }

    //dagger 2
    val dagger by lazy{ "com.google.dagger:dagger:${Versions.dagger}"}
    val daggerCompiler by lazy{ "com.google.dagger:dagger-compiler:${Versions.dagger}"}

    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}"}

}
object Modules {

    val UniList = ":list_module"
    val Detail = ":detail"
    val app = ":app"
    val core = ":core"

}
