pipeline {
   agent any
          /*
          
          
          https://www.journaldev.com/33645/maven-commands-options-cheat-sheet
          
            */
   stages {
      stage('GET-CODE') {
         steps {
            echo '====================================================='
            echo 'GET-CODE'
            echo '====================================================='
      /* catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
        {
                        bat  """
                              rd demoJGPDevSecOps /S /Q
                             """.stripIndent().trim()
         }*/
            git branch: 'master', url: 'https://perezjuang:86100252807aA*@github.com/perezjuang/gabriel-coding-tips.git'
         }
      }
      
      
      
      
    stage('TEST') {
         steps {
            echo '====================================================='
            echo 'TEST'
            echo '====================================================='
            dir ('demoJGPDevSecOps') { 
                bat  """
                      mvn verify
                     """.stripIndent().trim()
            }

         }
      }
      
      
    stage('COMPILE') {
         steps {
            echo '====================================================='
            echo 'COMPILE'
            echo '====================================================='
            dir ('demoJGPDevSecOps') { 
                bat  """
                      mvn package
                      mvn install
                     """.stripIndent().trim()
            }

         }
      }
          stage('GENERATEARTIFACTS') {
         steps {
            echo '====================================================='
            echo 'GENERATEARTIFACTS'
            echo '====================================================='
git 'commit --allow-empty -m "Dummy commit"'
git 'tag -a 1.0.0 -m "nothing here"'
git 'push --tags origin master' // triggers both workflows

         }
      }
      
      
      
   }
}