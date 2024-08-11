import kotlinx.coroutines.awaitCancellation
import org.mockito.kotlin.doSuspendableAnswer
import org.mockito.stubbing.OngoingStubbing


fun <T> OngoingStubbing<T>.thenThrowSafe(throwable: Throwable): OngoingStubbing<T> = thenAnswer { throw throwable }

fun <T> OngoingStubbing<T>.thenNeverAnswer(): OngoingStubbing<T> = doSuspendableAnswer { awaitCancellation() }