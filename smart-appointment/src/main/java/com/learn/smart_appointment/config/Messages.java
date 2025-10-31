package com.learn.smart_appointment.config;

public class Messages {

	// ==================== Email Messages ====================
	public static final String RESET_PASSWORD = "Reset your password";
	public static final String RESEND_CODE = "A new code was sent";
	public static final String FAILED_EMAIL = "Failed to send email. Please try again later";

	// ==================== Auth Messages ====================
	public static final String LOGIN_SUCCESS = "Login successfully";
	public static final String GOOGLE_LOGIN_SUCCESS = "Google login successful!";
	public static final String CREATE_NEW_USER = "New user created successfully";
	public static final String LOGOUT_SUCCESS = "Logged out successfully";
	public static final String ALREADY_LOGGED_OUT = "You are already logged out";
	public static final String INVALID_CONFIRM_EMAIL = "Invalid confirmation code";
	public static final String CONFIRM_EMAIL_SUCCESS = "Email confirmed successfully";
	public static final String INVALID_PASSWORD = "Current password is incorrect";
	public static final String CHANGE_PASSWORD = "Password changed successfully";
	public static final String CODE_SENT = "Code sent successfully";
	public static final String INVALID_RESET_CODE = "Invalid reset code";
	public static final String EMAIL_ALREADY_EXISTS = "Email already exists";
	public static final String USERNAME_ALREADY_EXISTS = "Username already exists";
	public static final String BAD_CREDENTIALS = "Invalid username or password";
	public static final String AUTH_FAILED = "Authentication failed";
	public static final String REQUEST_NOT_SUPPORTED = "Request method not supported";
	public static final String NOT_SALES_EMPLOYEE = "User does not have SALES_EMPLOYEE role.";
	public static final String NOT_PURCHASES_EMPLOYEE = "User does not have PURCHASING_OFFICER role.";

	// ==================== Token Messages ====================
	public static final String INVALID_REFRESH_TOKEN = "Invalid or missing refresh token";
	public static final String NEW_TOKEN_GENERATED = "New token generated successfully";
	public static final String COULD_NOT_EXTRACT_USER = "Unable to extract username from token";
	public static final String TOKEN_NOT_FOUND = "Token not found or invalid";
	public static final String TOKEN_EXPIRED_OR_REVOKED = "Token expired or revoked";
	public static final String SESSION_EXPIRED = "Your session has expired. Please login again";
	public static final String ACCESS_DENIED = "You do not have permission to access this resource";
	public static final String MISSING_TOKEN = "JWT token is missing";

	// ==================== User Messages ====================
	public static final String USER_NOT_FOUND = "User not found";
	public static final String USERNAME_NOT_FOUND = "User not found with username or email: ";
	public static final String USER_NOT_AUTHENTICATED = "User not authenticated";
	public static final String CHANGE_ROLES_ERROR = "Invalid role. Please provide one of: ADMIN, CUSTOMER, etc.";
	public static final String USER_UPDATE_PROFILE = "User role updated successfully";
	public static final String USER_UPDATE_IMAGE = "User image updated successfully";
	public static final String DELETE_USER = "User deleted successfully";
	public static final String UPDATE_USER = "User updated successfully";

	// ==================== Error Messages ====================
	public static final String FORMAT_ERROR = "Malformed JSON request";
	public static final String INVALID_DATA = "Invalid data. Please check your request body";
    public static final String INVALID_ID_FORMAT = "Invalid ID format. Must be a numeric value.";


	// ==================== Category Messages ====================
	public static final String CATEGORY_NOT_FOUND = "Category not found";
	public static final String PARENT_CATEGORY_NOT_FOUND = "Parent category not found";
	public static final String CATEGORY_ALREADY_EXISTS = "Category with this name already exists";
	public static final String DELETE_CATEGORY = "Category deleted successfully";
	public static final String ADD_CATEGORY = "Category added successfully";
	public static final String UPDATE_CATEGORY = "Category updated successfully";

	// ==================== Image Messages ====================
	public static final String EMPTY_IMAGE = "Image file is empty or null";
	public static final String UPLOAD_IMAGE_FAILED = "Error occurred while uploading image";

}