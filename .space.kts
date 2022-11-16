/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job(".NET Core desktop. Build, publish"){
    container(image = "mcr.microsoft.com/dotnet/core/sdk:6.0"){
        env["FEED_URL"] = "https://nuget.pkg.jetbrains.space/mycompany/p/pkey/mynuget/v3/index.json"
        shellScript {
            content = """
                echo Run build...
                dotnet build ./WebApp
                echo Publish NuGet package...
                chmod +x publish.sh
                ./publish.sh
            """
        }
    }
}