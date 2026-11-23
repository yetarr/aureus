@ApplicationModule(
        allowedDependencies = {
                "accounts",
                "ledger"
        }
)
package com.aureus.transfers;

import org.springframework.modulith.ApplicationModule;