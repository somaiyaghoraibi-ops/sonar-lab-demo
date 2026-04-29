# SE 4221 - SonarQube Cloud Lab Demo

Practice Maven project for the SonarQube Cloud lab.

## Setup

1. Sign in at https://sonarcloud.io and create an organization.
2. Click `+` (top-right) -> `Analyze new project`. On the *Analyze projects*
   screen fill in: Organization, Display Name (`sonar-lab-demo`),
   Project Key, Project Visibility = **Public**, then click **Next**.
3. On *Set up new code for project*, pick **Previous version** and click
   **Create project**.
4. On *Choose your Analysis Method* click **Manually**, then **Generate** a
   token on the next screen and **copy it immediately** (shown only once).
5. In `pom.xml` replace:
   - `YOUR_ORG_KEY` with the organization key
   - `YOUR_PROJECT_KEY` with the project key SonarQube Cloud shows you

## Run the analysis locally

Set `SONAR_TOKEN` in the environment, then run the Maven scanner:

```
# Windows PowerShell
$env:SONAR_TOKEN = "<your token>"

# Windows cmd
set SONAR_TOKEN=<your token>

# Linux / macOS
export SONAR_TOKEN=<your token>

mvn verify sonar:sonar
```

When the build finishes you will see a line like:

```
ANALYSIS SUCCESSFUL, you can find the results at:
https://sonarcloud.io/dashboard?id=<your project key>
```

Open that URL to read the report.

## What to explore

- `OrderProcessor` - code smells / cognitive complexity (Maintainability).
- `UserDao` - SQL injection, hardcoded credential, weak hashing (Security).
- `CalculatorTest` - add more tests so coverage >= 80%.
