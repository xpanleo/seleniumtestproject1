

class PageActionSpec extends BaseSpec {

    def "Create group policy"() {

        given: "An individual customer is successfully created"
//        String data = "regisCustomer1"
//        navigateLoginAndLoginToDashBoard(data)
//        String customerId = registerIndividualCustomer()
//        userLogout()

        //For debugging purposes
        //String customerId = "1160"

        when: "I log in with an account having policy creation rights"
//        navigateLoginAndLoginToDashBoard("policyCreator1")
//        CreatePolicyPage policyPage = dashboardPage.clickOnCreatePolicy()

        and: "I search  for the previously created customer"
//        policyPage.searchCustomer(customerId)

        and: "I fill in the policy details for this customer"
//        policyPage.fillPolicyInformation(currentEnrollmentData)
//        policyPage.fillSalesDetails(currentEnrollmentData)
//        policyPage.fillCategoryRelationAndGroupCoverages(currentEnrollmentData)
//        policyPage.clickProceedButton()

        and: "I create a member"
//        policyPage.fillMemberInformation(currentEnrollmentData)
//        policyPage.fillMemberInformationMoreDetails(currentEnrollmentData)
//        policyPage.fillBillingInformation(currentEnrollmentData)
//        policyPage.fillAddress(currentEnrollmentData)
//        policyPage.fillContactInfo(currentEnrollmentData)

        and: "I create a second member"
//        policyPage.createMember()
//        String membersAddedMilestone = policyPage.getMessage(CreatePolicyPageObjects.ADD_MEMBER_MILESTONE)

        then: "The member addition milestone appears"
//        "Members Added" == membersAddedMilestone

        when: "I click on Proceed button"
//        policyPage.clickProceedButton()

        and: "I compute the created policy"
//        policyPage.compute()
//        String policyComputedMilestone = policyPage.getMessage(CreatePolicyPageObjects.COMPUTED_MILESTONE)

        then: "The policy computed milestone appears"
//        "Policy Computed" == policyComputedMilestone

        when: "I close the created policy task"
//        policyPage.closeTask()
//        tasksListPage = new TasksListPage(driver, timings)
//        TimeUnit.SECONDS.sleep(2)

        then: "Logout"
//        policyPage.logoutWeb()

    }
}