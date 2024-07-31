package ru.ktstech.module.template.plugin.template.module.recipes.kmp.feature

import com.android.tools.idea.wizard.template.*
import ru.ktstech.module.template.plugin.common.pascalCase

val kmpFeatureModuleTemplate
    get() = template {
        name = "KMP Feature Module"
        description = "Shared feature module for kmp"

        category = Category.Folder
        formFactor = FormFactor.Mobile

        useGenericAndroidTests = false
        useGenericLocalTests = false

        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule,
        )

        val classPrefix = stringParameter {
            name = "Введите префикс для классов модуля"
            default = ""
        }

        val withMVI = booleanParameter {
            name = "Добавить MVI Kotlin"
            default = true
        }

        val withRepository = booleanParameter {
            name = "Добавить Repository"
            default = true
        }

        val withApi = booleanParameter {
            name = "Добавить Api"
            default = true
        }

        val withImpl = booleanParameter {
            name = "Добавить Impl"
            default = true
        }

        val withPresentation = booleanParameter {
            name = "Добавить Presentation"
            default = true
        }

        widgets(
            TextFieldWidget(classPrefix),
            Separator,
            CheckBoxWidget(withMVI),
            CheckBoxWidget(withRepository),
            Separator,
            CheckBoxWidget(withApi),
            CheckBoxWidget(withImpl),
            CheckBoxWidget(withPresentation),
        )

        recipe = { data: TemplateData ->
            createKmpFeatureModuleFiles(
                moduleData = data as ModuleTemplateData,
                classPrefix = classPrefix.value.pascalCase(),
                withMVI = withMVI.value,
                withApi = withApi.value,
                withImpl = withImpl.value,
                withRepository = withRepository.value,
                withPresentation = withPresentation.value,
            )
        }
    }