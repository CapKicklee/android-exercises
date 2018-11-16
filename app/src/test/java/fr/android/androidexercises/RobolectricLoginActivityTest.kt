package fr.android.androidexercises

import android.view.View
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.mockk.verifyAll
import org.amshove.kluent.shouldEqualTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RobolectricLoginActivityTest {
    // TODO test login activity with Robolectric and MockK
    @RelaxedMockK
    private lateinit var activity: LoginActivity

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        activity = Robolectric.setupActivity(LoginActivity::class.java)
    }

    @Test
    fun should_set_logged_state() {
        activity.logged()
        activity.loginLayout.visibility shouldEqualTo View.GONE
        activity.loggedText.visibility shouldEqualTo View.VISIBLE
    }

    @Test
    fun should_set_not_logged_state() {
        activity.notLogged()
        activity.loginLayout.visibility shouldEqualTo View.VISIBLE
        activity.loggedText.visibility shouldEqualTo View.GONE
    }
}