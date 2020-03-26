# sbertest_allure-cucumber

java -jar agent.jar -jnlpUrl http://localhost:8080/computer/apltest_agent/slave-agent.jnlp -secret d0f9a3d2d9f0e84b054662a15b513dbb5fb3de105528b787fcfaa30271e432a6 -workDir "D:\jenk"

mvn clean test -DTAGS="@all"
tags are optional
