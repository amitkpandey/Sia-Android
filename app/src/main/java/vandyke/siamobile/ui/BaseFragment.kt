package vandyke.siamobile.ui

import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {
    open fun onBackPressed(): Boolean = false
}