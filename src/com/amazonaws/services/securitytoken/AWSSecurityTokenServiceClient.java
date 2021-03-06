/*
 * Copyright 2010-2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.securitytoken;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.handlers.RequestHandler;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.StandardErrorUnmarshaller;

import com.amazonaws.services.securitytoken.model.*;
import com.amazonaws.services.securitytoken.model.transform.*;


/**
 * Client for accessing AWSSecurityTokenService.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * AWS Security Token Service <p>
 * The AWS Security Token Service is a web service that enables you to request temporary, limited-privilege credentials for AWS Identity and Access
 * Management (IAM) users or for users that you authenticate (federated users). This guide provides descriptions of the AWS Security Token Service API.
 * </p>
 * <p>
 * For more detailed information about using this service, go to <a href="http://docs.amazonwebservices.com/IAM/latest/UsingSTS/Welcome.html"> Using
 * Temporary Security Credentials </a> .
 * </p>
 * <p>
 * For information about setting up signatures and authorization through the API, go to <a
 * href="http://docs.amazonwebservices.com/general/latest/gr/signing_aws_api_requests.html"> Signing AWS API Requests </a> in the <i>AWS General
 * Reference</i> . For general information about the Query API, go to <a
 * href="http://docs.amazonwebservices.com/IAM/latest/UserGuide/IAM_UsingQueryAPI.html"> Making Query Requests </a> in <i>Using IAM</i> . For
 * information about using security tokens with other AWS products, go to <a
 * href="http://docs.amazonwebservices.com/IAM/latest/UsingSTS/UsingTokens.html"> Using Temporary Security Credentials to Access AWS </a> in <i>Using
 * Temporary Security Credentials</i> .
 * </p>
 * <p>
 * If you're new to AWS and need additional technical information about a specific AWS product, you can find the product's technical documentation at <a
 * href="http://aws.amazon.com/documentation/"> http://aws.amazon.com/documentation/ </a> .
 * </p>
 * <p>
 * We will refer to Amazon Identity and Access Management using the abbreviated form IAM. All copyrights and legal protections still apply.
 * </p>
 */
public class AWSSecurityTokenServiceClient extends AmazonWebServiceClient implements AWSSecurityTokenService {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AWSSecurityTokenService exceptions.
     */
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers
            = new ArrayList<Unmarshaller<AmazonServiceException, Node>>();

    
    /** AWS signer for authenticating requests. */
    private AWS4Signer signer;


    /**
     * Constructs a new client to invoke service methods on
     * AWSSecurityTokenService.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProvider
     */
    public AWSSecurityTokenServiceClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSSecurityTokenService.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AWSSecurityTokenService
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProvider
     */
    public AWSSecurityTokenServiceClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSSecurityTokenService using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AWSSecurityTokenServiceClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSSecurityTokenService using the specified AWS account credentials
     * and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AWSSecurityTokenService
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AWSSecurityTokenServiceClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSSecurityTokenService using the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AWSSecurityTokenServiceClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSSecurityTokenService using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AWSSecurityTokenService
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AWSSecurityTokenServiceClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    private void init() {
        exceptionUnmarshallers.add(new PackedPolicyTooLargeExceptionUnmarshaller());
        exceptionUnmarshallers.add(new MalformedPolicyDocumentExceptionUnmarshaller());
        
        exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("sts.amazonaws.com");

        signer = new AWS4Signer();
        
        signer.setServiceName("sts");
        

        HandlerChainFactory chainFactory = new HandlerChainFactory();
		requestHandlers.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/securitytoken/request.handlers"));
    }

    
    /**
     * <p>
     * The GetSessionToken action returns a set of temporary credentials for
     * an AWS account or IAM user. The credentials consist of an Access Key
     * ID, a Secret Access Key, and a security token. These credentials are
     * valid for the specified duration only. The session duration for IAM
     * users can be between 15 minutes and 36 hours, with a default of 12
     * hours. The session duration for AWS account owners is restricted to a
     * maximum of one hour. Providing the AWS Multi-Factor Authentication
     * (MFA) device serial number and the token code is optional.
     * </p>
     * <p>
     * For more information about using GetSessionToken to create temporary
     * credentials, go to <a
     * mazonwebservices.com/IAM/latest/UserGuide/CreatingSessionTokens.html">
     * Creating Temporary Credentials to Enable Access for IAM Users </a> in
     * <i>Using IAM</i> .
     * </p>
     *
     * @param getSessionTokenRequest Container for the necessary parameters
     *           to execute the GetSessionToken service method on
     *           AWSSecurityTokenService.
     * 
     * @return The response from the GetSessionToken service method, as
     *         returned by AWSSecurityTokenService.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSSecurityTokenService indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetSessionTokenResult getSessionToken(GetSessionTokenRequest getSessionTokenRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<GetSessionTokenRequest> request = new GetSessionTokenRequestMarshaller().marshall(getSessionTokenRequest);
        return invoke(request, new GetSessionTokenResultStaxUnmarshaller());
    }
    
    /**
     * <p>
     * The GetFederationToken action returns a set of temporary credentials
     * for a federated user with the user name and policy specified in the
     * request. The credentials consist of an Access Key ID, a Secret Access
     * Key, and a security token. Credentials created by IAM users are valid
     * for the specified duration, between 15 minutes and 36 hours;
     * credentials created using account credentials have a maximum duration
     * of one hour.
     * </p>
     * <p>
     * The federated user who holds these credentials has any permissions
     * allowed by the intersection of the specified policy and any resource
     * or user policies that apply to the caller of the GetFederationToken
     * API, and any resource policies that apply to the federated user's
     * Amazon Resource Name (ARN). For more information about how token
     * permissions work, see <a
     * ocs.amazonwebservices.com/IAM/latest/UserGuide/TokenPermissions.html">
     * Controlling Permissions in Temporary Credentials </a> in <i>Using
     * IAM</i> . For information about using GetFederationToken to create
     * temporary credentials, see <a
     * cs.amazonwebservices.com/IAM/latest/UserGuide/CreatingFedTokens.html">
     * Creating Temporary Credentials to Enable Access for Federated Users
     * </a> in <i>Using IAM</i> .
     * </p>
     *
     * @param getFederationTokenRequest Container for the necessary
     *           parameters to execute the GetFederationToken service method on
     *           AWSSecurityTokenService.
     * 
     * @return The response from the GetFederationToken service method, as
     *         returned by AWSSecurityTokenService.
     * 
     * @throws PackedPolicyTooLargeException
     * @throws MalformedPolicyDocumentException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSSecurityTokenService indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetFederationTokenResult getFederationToken(GetFederationTokenRequest getFederationTokenRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<GetFederationTokenRequest> request = new GetFederationTokenRequestMarshaller().marshall(getFederationTokenRequest);
        return invoke(request, new GetFederationTokenResultStaxUnmarshaller());
    }
    
    /**
     * <p>
     * The <code>AssumeRole</code> action returns a set of temporary
     * security credentials that you can use to access resources that are
     * defined in the role's policy. The returned credentials consist of an
     * Access Key ID, a Secret Access Key, and a security token.
     * </p>
     * <p>
     * <b>Important:</b> Only IAM users can assume a role. If you use AWS
     * account credentials to call AssumeRole, access is denied.
     * </p>
     * <p>
     * The credentials are valid for the duration that you specified when
     * calling <code>AssumeRole</code> , which can be from 15 minutes to 1
     * hour.
     * </p>
     * <p>
     * When you assume a role, you have the privileges that are defined in
     * the role. You can further restrict the privileges by passing a policy
     * when calling <code>AssumeRole</code> .
     * 
     * </p>
     * <p>
     * To assume a role, you must be an IAM user from a trusted entity and
     * have permission to call <code>AssumeRole</code> .
     * Trusted entites are defined when the IAM role is created.
     * Permission to call <code>AssumeRole</code> is defined in your or your
     * group's IAM policy.
     * </p>
     * <p>
     * </p>
     * <p>
     * </p>
     * <p>
     * </p>
     * <p>
     * </p>
     * <p>
     * </p>
     *
     * @param assumeRoleRequest Container for the necessary parameters to
     *           execute the AssumeRole service method on AWSSecurityTokenService.
     * 
     * @return The response from the AssumeRole service method, as returned
     *         by AWSSecurityTokenService.
     * 
     * @throws PackedPolicyTooLargeException
     * @throws MalformedPolicyDocumentException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSSecurityTokenService indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public AssumeRoleResult assumeRole(AssumeRoleRequest assumeRoleRequest) 
            throws AmazonServiceException, AmazonClientException {
        Request<AssumeRoleRequest> request = new AssumeRoleRequestMarshaller().marshall(assumeRoleRequest);
        return invoke(request, new AssumeRoleResultStaxUnmarshaller());
    }
    
    /**
     * <p>
     * The GetSessionToken action returns a set of temporary credentials for
     * an AWS account or IAM user. The credentials consist of an Access Key
     * ID, a Secret Access Key, and a security token. These credentials are
     * valid for the specified duration only. The session duration for IAM
     * users can be between 15 minutes and 36 hours, with a default of 12
     * hours. The session duration for AWS account owners is restricted to a
     * maximum of one hour. Providing the AWS Multi-Factor Authentication
     * (MFA) device serial number and the token code is optional.
     * </p>
     * <p>
     * For more information about using GetSessionToken to create temporary
     * credentials, go to <a
     * mazonwebservices.com/IAM/latest/UserGuide/CreatingSessionTokens.html">
     * Creating Temporary Credentials to Enable Access for IAM Users </a> in
     * <i>Using IAM</i> .
     * </p>
     * 
     * @return The response from the GetSessionToken service method, as
     *         returned by AWSSecurityTokenService.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSSecurityTokenService indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetSessionTokenResult getSessionToken() throws AmazonServiceException, AmazonClientException {
        return getSessionToken(new GetSessionTokenRequest());
    }
    
    /**
     * Overrides the default endpoint for this client ("https://sts.amazonaws.com") and explicitly provides
     * an AWS region ID and AWS service name to use when the client calculates a signature
     * for requests.  In almost all cases, this region ID and service name
     * are automatically determined from the endpoint, and callers should use the simpler
     * one-argument form of setEndpoint instead of this method.
     * <p>
     * <b>This method is not threadsafe. Endpoints should be configured when the
     * client is created and before any service requests are made. Changing it
     * afterwards creates inevitable race conditions for any service requests in
     * transit.</b>
     * <p>
     * Callers can pass in just the endpoint (ex: "sts.amazonaws.com") or a full
     * URL, including the protocol (ex: "https://sts.amazonaws.com"). If the
     * protocol is not specified here, the default protocol from this client's
     * {@link ClientConfiguration} will be used, which by default is HTTPS.
     * <p>
     * For more information on using AWS regions with the AWS SDK for Java, and
     * a complete list of all available endpoints for all AWS services, see:
     * <a href="http://developer.amazonwebservices.com/connect/entry.jspa?externalID=3912">
     * http://developer.amazonwebservices.com/connect/entry.jspa?externalID=3912</a>
     *
     * @param endpoint
     *            The endpoint (ex: "sts.amazonaws.com") or a full URL,
     *            including the protocol (ex: "https://sts.amazonaws.com") of
     *            the region specific AWS endpoint this client will communicate
     *            with.
     * @param serviceName
     *            The name of the AWS service to use when signing requests.
     * @param regionId
     *            The ID of the region in which this service resides.
     *
     * @throws IllegalArgumentException
     *             If any problems are detected with the specified endpoint.
     */
    public void setEndpoint(String endpoint, String serviceName, String regionId) throws IllegalArgumentException {
        setEndpoint(endpoint);
        signer.setServiceName(serviceName);
        signer.setRegionName(regionId);
    }
    

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, Unmarshaller<X, StaxUnmarshallerContext> unmarshaller) {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);
        for (Entry<String, String> entry : request.getOriginalRequest().copyPrivateRequestParameters().entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
        	credentials = originalRequest.getRequestCredentials();
        }

        ExecutionContext executionContext = createExecutionContext();
        executionContext.setSigner(signer);
        executionContext.setCredentials(credentials);
        
        StaxResponseHandler<X> responseHandler = new StaxResponseHandler<X>(unmarshaller);
        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return (X)client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }
}
        