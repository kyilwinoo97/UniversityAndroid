import com.assessment.universityandroid.core.di.CoreComponent
import com.assessment.universityandroid.core.di.scopes.FeatureScope
import com.assessment.universityandroid.list_module.di.ViewModelModule
import com.assessment.universityandroid.list_module.presentaion.UniListActivity
import dagger.Component

@FeatureScope
@Component(
    modules = [UniListModule::class,ViewModelModule::class],
    dependencies = [CoreComponent::class]
)
interface UniListComponent {
    fun inject(uniListActivity: UniListActivity)
}
