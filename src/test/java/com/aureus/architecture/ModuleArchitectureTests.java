package com.aureus.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(
        packages = "com.aureus",
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class ModuleArchitectureTests {

    @ArchTest
    static final ArchRule modulesShouldBeFreeOfCycles =
            slices()
                    .matching("com.aureus.(*)..")
                    .should()
                    .beFreeOfCycles()
                    .allowEmptyShould(true);
}
