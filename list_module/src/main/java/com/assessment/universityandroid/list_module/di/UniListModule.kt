import android.app.Application
import com.assessment.universityandroid.core.database.UniDatabase
import com.assessment.universityandroid.core.database.UniversityDao
import com.assessment.universityandroid.core.di.scopes.FeatureScope
import com.assessment.universityandroid.core.network.ApiInterface
import com.assessment.universityandroid.core.network.UniRepository
import com.assessment.universityandroid.core.network.UniRepositoryImpl
import com.assessment.universityandroid.list_module.presentaion.UniListActivity
import com.assessment.universityandroid.list_module.presentaion.UniversityListViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class UniListModule(
    val activity: UniListActivity
) {
    @FeatureScope
    @Provides
    fun providesUniListViewModel(
        repository: UniRepositoryImpl
    ) :UniversityListViewModel {
       return UniversityListViewModel(repository)
    }


}
