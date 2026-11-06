# Publication changes

- Retained the author credit and removed student IDs, class section numbers, and class-day headers.
- Selected only the bank and employee applications; omitted unrelated names/numbers exercises and IDE files.
- Fixed the employee maximum-salary search, which previously returned the last matching employee.
- Corrected the department name shown by the employee menu and rejected invalid employee details.
- Guarded employee display/bonus indexes.
- Initialized storage in the default bank constructor.
- Corrected withdrawal success reporting and allowed an exact-balance withdrawal or transfer.
- Replaced the cross-bank search over unused array slots, which could dereference null entries.
- Validated transfer recipients and amounts before mutating balances; rejected negative/nonfinite amounts, overdrafts, and self-transfers.
- Added regression checks and scripted console checks using fictional data.

The examples remain small coursework applications. Their original local source files were not modified.
