# CodeAssignment_TestVagrant

<h2>Problem Statement:</h2>
<ul>
<li>1. Write test to validate that the team has only 4 foreign players</li>
<li>2. Write test to validate that their is atleast one wicketkeeper </li>
  
<h2>TechStack:</h2>
<ul>
<li>Java 8,Maven,TestNG,JSON-Simple</li>
<li> IDE : Eclipse </li>
</ul>

<h2>Steps to Run Project</h2>
<ul>
  <li>1. using maven commands</li>
  <li>clone this project and run command mvn clean test </li>
  <li>Once test execution completed verify the  report under  /TeamRCB/test-output/emailable-report.html </li>
</ul>
  
  <ul>
  <li>2. using testng XML </li>
  <li>clone this project and run testng.xml </li>
  <li> verify the  testresults under  /TeamRCB/test-output/emailable-report.html </li>
</ul>

<h2>Project Setup </h2>
<ul>
<li>Create a Maven project   added dependencies for TestNG, JSon-Simple in POM. XML</li>
<li>Folder Structure  :</li>
<li>src/main/java contains ReadJSonUtils.java holds the logic to read the JSON file and find the count of Foriegn Players and WicketKeeper from input Json </li>
<li>src/test/test contains RCBTeamValidationTest.java contains the test method to assert foriegn players and Wicket keeper . </li>
<li>src/test/resources contains input Json file</li>
<li>Testing.XML --> contains parameter here will  pass the foreignplayer and wicketkeeper count</li>
<li>Report-->/test-output/emailable-report.html</li>


