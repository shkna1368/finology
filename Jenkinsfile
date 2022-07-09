node {
  stage ('Build') {
    git url: 'https://github.com/shkna1368/finology.git'
    withMaven {
      bat "mvn clean verify"
    } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
  }
}
