package pl.arturborowy.logger.tag

import pl.arturborowy.logger.data.TagSettingsRepository
import pl.arturborowy.logger.tag.dataprovider.TagData
import pl.arturborowy.logger.tag.dataprovider.TagDataProvider

class TagBuilder(private val tagDataProvider: TagDataProvider,
                 private val tagSettingsRepository: TagSettingsRepository) {

    companion object {
        private const val PACKAGE_SEPARATOR = '.'
    }

    private val defaultTagSettings = tagSettingsRepository.defaultTagSettings

    fun build(withFileNameAndLineNr: Boolean?,
              withClassName: Boolean?,
              withMethodName: Boolean?): String {
        val tagData = tagDataProvider.getTagData()

        return if (tagData == null) {
            ""
        } else {
            build(tagData,
                    withFileNameAndLineNr ?: defaultTagSettings.shouldLogFileNameAndLineNr,
                    withClassName ?: defaultTagSettings.shouldLogClassName,
                    withMethodName ?: defaultTagSettings.shouldLogMethodName)
        }
    }

    fun buildForThrowable() =
            build(withFileNameAndLineNr = true,
                    withClassName = false,
                    withMethodName = false)

    private fun build(tagData: TagData,
                      withFileNameAndLineNr: Boolean,
                      withClassName: Boolean,
                      withMethodName: Boolean): String {
        val fileNameWithLineNr = getTagElement(withFileNameAndLineNr,
                "(${tagData.fileName}:${tagData.lineNumber})")

        val className = getTagElement(withClassName,
                removePackageFromClassName(tagData.className))

        val methodName = getTagElement(withMethodName,
                ".${tagData.methodName}()")

        val output = "$fileNameWithLineNr $className$methodName"

        return if (output == " ") {
            " "
        } else {
            output.removePrefix(" ").removeSuffix(" ")
        }
    }

    private fun removePackageFromClassName(classWithPackage: String) =
            classWithPackage.substring(classWithPackage.indexOfLast { it == PACKAGE_SEPARATOR } + 1)

    private fun getTagElement(isElementIncluded: Boolean, element: String) =
            if (isElementIncluded) {
                element
            } else {
                ""
            }
}