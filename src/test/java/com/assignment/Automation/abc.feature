@Regression
Feature: FindLoanAccountById Account API

  Background:
    * def automUtil = Java.type('com.aexp.lending.loan.accounts.util.AutomationUtil')


  Scenario: findByLoanAcc using criteria with LoanAccountNumber_LO1
