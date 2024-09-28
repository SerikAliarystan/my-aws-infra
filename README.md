
# AWS Lambda Redirect with AWS CDK

This project demonstrates how to create an AWS Lambda function for HTTP redirect using AWS CDK and Java.

## Project Structure

- **`lambda-redirect/`**: Contains the Lambda function source code.
- **`build.gradle`**: The main build file for the project.
- **`cdk.json`**: Configuration file for CDK.
- **`gradlew` & `gradlew.bat`**: Gradle wrapper scripts for Linux/Mac and Windows, respectively.
- **`settings.gradle`**: Configuration file that defines the structure of the Gradle project.

## Prerequisites

1. **Java 17**: Ensure that Java 17 is installed and configured in your environment.
2. **AWS CLI**: Install and configure the AWS CLI with appropriate permissions.
3. **AWS CDK**: Install the AWS CDK toolkit globally.
   ```bash
   npm install -g aws-cdk
   ```
4. **Gradle**: If Gradle is not installed, use the Gradle wrapper provided (`./gradlew`) for build and setup tasks.

## Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-repo/my-aws-infra.git
   cd my-aws-infra
   ```

2. **Set up AWS credentials:**
   Ensure your AWS CLI is configured with the correct profile and permissions:
   ```bash
   aws configure --profile your-account
   ```

3. **Build the Lambda function:**
   Compile the Lambda function and create the JAR file.
   ```bash
   ./gradlew clean build
   ```

4. **Bootstrap your AWS environment:**
   Run the bootstrap command to set up resources needed by CDK in your AWS account:
   ```bash
   cdk bootstrap --profile your-account
   ```

5. **Synthesize the CloudFormation template:**
   Generate a CloudFormation template based on the CDK constructs defined in your project:
   ```bash
   cdk synth --profile your-account
   ```

6. **Deploy the stack:**
   Deploy the resources defined in your CDK application to your AWS account:
   ```bash
   cdk deploy --profile your-account
   ```

7. **Verify Deployment:**
   After deployment, verify the API Gateway URL and ensure the Lambda function correctly redirects to the desired URL.

## Useful Commands

- **Clean and build the project:**
  ```bash
  ./gradlew clean build
  ```

- **Synthesize the CloudFormation template:**
  ```bash
  cdk synth --profile your-account
  ```

- **Deploy the stack:**
  ```bash
  cdk deploy --profile your-account
  ```

- **Destroy the stack:**
  To remove all resources created by this stack:
  ```bash
  cdk destroy --profile your-account
  ```

## Troubleshooting

1. **`UnsupportedClassVersionError`:** Ensure that both the project and Lambda runtime are set to Java 17.
2. **Gradle Cache Issues:** If you encounter issues with the Gradle cache, clean it:
   ```bash
   ./gradlew clean
   rm -rf ~/.gradle/caches/
   ```

## License

This project is licensed under the MIT License.
