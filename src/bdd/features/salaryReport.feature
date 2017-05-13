Feature:

  Scenario: verify report content for month which has last day on working day
    Given Payroll accountant with access to reports
    And Test month with defined <last day>
    When Monthly report is generated
    Then Report format is "..."
    And Report name is the samme as it was defined by user
    And Report can be opened
    And Base salaries are paid on the last day of the month
    And Bonuses pay date is the 15th of the month



  Scenario: verify report content for month which has last day on Saturday or Sunday
      Given Payroll accountant with access to reports
      And Test month with defined <last day>
      When Monthly report is generated
      Then Report format is "..."
      And Report name is the same as it was defined by user
      And Report can be opened
      And Base salaries are paid on the last day before the weekend
      And Bouses pay day is the first Wednesday after the 15th

  Examples:
  |last day|
  |Saturday|
  |Sunday|



  Questions:
    Which format of report will payroll accountant receive? (.doc, excel, csv) Do you have a template or mockups for report? What content should be in report?
    Regular monthly report. Should we use trigger for getting of such reports? Should it be first day of month? At what time?
    I would like to clarity users types/accounts and their permissions. How sales staff is defined? Will report be sent
  to sales staff to email?
    In workflow schema there is a step with getting output filename. I would like to know how accountant will input filename?
    Will filename include path to file and file extension?
    Should we include bank holidays/holidays into base salaries pay day definition?

