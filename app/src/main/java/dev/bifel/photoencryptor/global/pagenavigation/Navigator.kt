package dev.bifel.photoencryptor.global.pagenavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavTransactionOptions
import dev.bifel.photoencryptor.R
import dev.bifel.photoencryptor.global.base.NavigableFragment
import dev.bifel.photoencryptor.global.pagenavigation.Screen.Companion.getScreen

class Navigator(
    savedInstanceState: Bundle?,
    supportFragmentManager: FragmentManager,
    rootContainerId: Int,
    root: Screen
) {

    private val fragNavController = FragNavController.newBuilder(
        savedInstanceState,
        supportFragmentManager,
        rootContainerId
    ).rootFragment(root.fragment)
        .defaultTransactionOptions(
            FragNavTransactionOptions.newBuilder()
                .customAnimations(
                    R.anim.slide_in_from_right,
                    R.anim.slide_out_to_left,
                    R.anim.slide_in_from_left,
                    R.anim.slide_out_to_right
                )
                .build()
        ).build()

    private val popsToRoot
        get() = fragNavController.currentStack!!.size - 1
    private val noAnimation = FragNavTransactionOptions.newBuilder().build()

    val current: NavigableFragment
        get() = fragNavController.currentFrag as NavigableFragment

    val isRoot: Boolean
        get() = fragNavController.isRootFragment

    fun onSaveInstanceState(outState: Bundle?) =
        fragNavController.onSaveInstanceState(outState ?: Bundle())

    fun add(fragment: Fragment, animate: Boolean) {
        fragNavController.pushFragment(
            fragment,
            if (animate) null else noAnimation
        )
        (fragment as NavigableFragment).onShow()
    }

    private fun addWithoutAnimation(fragment: Fragment) = add(fragment, false)

    fun add(screen: Screen) = add(screen.fragment, true)

    fun addWithoutAnimation(screen: Screen) = addWithoutAnimation(screen.fragment)

    private fun replace(fragment: Fragment) = fragNavController.replaceFragment(fragment)

    fun replace(screen: Screen) = replace(screen.fragment)

    fun popToRoot() = pop(popsToRoot)

    fun popTo(screen: Screen) =
        fragNavController.currentStack?.findLast { screen == getScreen(it) }.let { fragment ->
            fragNavController.currentStack
                ?.let { stack ->
                    val indexOf = stack.indexOf(fragment)
                    if (indexOf <= 0) popsToRoot else stack.size - (indexOf + 1)
                }
                ?.let { pop(it) }
            current.onShow()
        }

    fun pop(count: Int = 1, animate: Boolean) {
        fragNavController.popFragments(count, if (animate) null else noAnimation)
        current.onShow()
    }

    fun pop(count: Int = 1) = pop(count, true)

    fun popWithoutAnimation(count: Int = 1) = pop(count, false)

    fun setRoot(screen: Screen) {
        fragNavController.clearStack()
        replace(screen)
    }
}