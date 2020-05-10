Feature: hr Application Database an UI data verification
  @data
  Scenario: Department data Ui and  Database verification
    Given I am on DeptEmpPage
    When I search for department id 10
    Then I query database with sql "Select department_name, manager_id, location_od from departments where deparment_id=10"
    Then UI Data and database data must macth