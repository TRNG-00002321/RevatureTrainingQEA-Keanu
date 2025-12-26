::!/bin/bash

::Clean previous reports
rm -rf reports allure-results allure-report

:: Create report directories
mkdir -p reports allure-results

:: Run tests with multiple formatters
behave \
    --format pretty \
    --format json:reports/results.json \
    --format allure_behave.formatter:AllureFormatter -o allure-results \
    $@

:: Generate JUnit XML report
behave --format junit --outfile reports/junit.xml $@ 2>/dev/null || true

:: Display summary
echo ""
echo "Reports generated:"
echo "  - Pretty output: console"
echo "  - JSON: reports/results.json"
echo "  - JUnit: reports/junit.xml"
echo "  - Allure: allure-results/"
echo ""
echo "To view Allure report:"
echo "  allure serve allure-results"