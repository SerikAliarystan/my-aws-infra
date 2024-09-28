package com.myorg;

import software.amazon.awscdk.services.apigateway.*;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

import java.util.List;
import java.util.Map;

public class MyAWSInfraStack extends Stack {
    public MyAWSInfraStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public MyAWSInfraStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        //Lambda
        Function redirectFunction = Function.Builder.create(this, "RedirectFunction")
                .runtime(Runtime.JAVA_17)
                .handler("com.myorg.RedirectLambda::handleRequest")
                .code(Code.fromAsset("./lambda-redirect/build/libs/redirect-lambda.jar"))
                .build();

        //API Gateway
        LambdaRestApi api = LambdaRestApi.Builder.create(this, "RedirectApi")
                .handler(redirectFunction)
                .build();

        // Resource /redirect
        Resource redirectResource = api.getRoot().addResource("redirect");

        // Integration Lambda with GET method
        redirectResource.addMethod("GET", new LambdaIntegration(redirectFunction),
                MethodOptions.builder()
                        .methodResponses(List.of(
                                MethodResponse.builder()
                                        .statusCode("302")
                                        .responseParameters(Map.of(
                                                "method.response.header.Location", true
                                        ))
                                        .build()
                        ))
                        .build());
    }
}
