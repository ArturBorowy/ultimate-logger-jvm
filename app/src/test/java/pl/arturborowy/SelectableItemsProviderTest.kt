package pl.arturborowy

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import pl.arturborowy.ui.common.recycleradapter.provider.clickable.SelectableItemsProvider

class SelectableItemsProviderTest {

    companion object {
        val givenItems = listOf("a", "b", "c", "d", "e")
    }

    private lateinit var selectableItemsProvider: SelectableItemsProvider<String>

    @Before
    fun setUp() {
        val mockOnItemClickAction: (String) -> Unit = {}
        selectableItemsProvider = object : SelectableItemsProvider<String>(mockOnItemClickAction) {
            override val items = givenItems
        }
    }

    @Test
    fun `isItemOnThisPositionSelected expected = false`() {
        val selectedItemIndex = 1
        selectableItemsProvider.selectedItem = givenItems[selectedItemIndex]

        val expected = false

        val itemToCheckIndex = 0
        val actual = selectableItemsProvider.isItemOnThisPositionSelected(itemToCheckIndex)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `isItemOnThisPositionSelected expected = true`() {
        val selectedItemIndex = 1
        selectableItemsProvider.selectedItem = givenItems[selectedItemIndex]

        val expected = true

        val itemToCheckIndex = 1
        val actual = selectableItemsProvider.isItemOnThisPositionSelected(itemToCheckIndex)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `isItemOnThisPositionSelected try check item bigger then items count`() {
        val selectedItemIndex = 0
        selectableItemsProvider.selectedItem = givenItems[selectedItemIndex]

        val expected = false

        val itemToCheckIndex = 10
        val actual = selectableItemsProvider.isItemOnThisPositionSelected(itemToCheckIndex)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `isItemOnThisPositionSelected try check item negative indexed`() {
        val selectedItemIndex = 0
        selectableItemsProvider.selectedItem = givenItems[selectedItemIndex]

        val expected = false

        val itemToCheckIndex = -1
        val actual = selectableItemsProvider.isItemOnThisPositionSelected(itemToCheckIndex)

        Assert.assertEquals(expected, actual)
    }
}