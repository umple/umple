# AI Requirements Generator - Documentation

## Overview

The AI Requirements Generator is a feature in UmpleOnline that uses Large Language Models (LLMs) to automatically generate Umple code from requirements expressed using Umple's `req` keyword. This feature can generate:

- **State Machines** - Convert requirement descriptions into state machines with states, events, and transitions
- **Class Diagrams** - Generate classes, attributes, and associations from requirement descriptions

## Understanding Umple Requirements

Before using the AI generator, it's important to understand Umple's requirements feature. Requirements allow for the same comment to appear in different sections of the code without typing out the comment multiple times.

### Requirements Components

Requirements consist of two components:

1. **Requirement Definition** - Contains the comment statement to be added
   ```umple
   req R01 {
     This is a comment we would like to add
     multiple times in different locations.
     The identifier used for this requirement is R01.
   }
   ```

2. **Requirement Implementation** - Specifies where the requirement statement should be added using `implementsReq`
   ```umple
   implementsReq R01;
   ```

### Implementing Requirements

Multiple requirements can be called through an `implementsReq` statement:

```umple
req R01 {
  This is a comment we would like to add
  multiple times in different locations.
}

req R02 {
  This is a second requirement statement.
}

implementsReq R01;

class Example {
  implementsReq R02;
  var1;
  var2;
  implementsReq R01, R02;
}
```

### Requirement Tagging

A requirement can be tagged with multiple entities like classes, attributes, associations, state machines, traits, methods, interfaces, etc.:

```umple
req R1 { First requirement with the identifier R1. }
req R2 { Second requirement with the identifier R2. }
req R3 { Third requirement with the identifier R3. }

// Requirements tagged with class
implementsReq R3;
class A {
  // Requirements tagged with attribute
  implementsReq R2;
  att1;
}

class B {
  // Requirement tagged with association
  implementsReq R2;
  * -> * A;
  
  // Requirement tagged with state machine
  implementsReq R3;
  sm {
    s1 { e -> s2; }
    s2 {}
  }
  
  // Requirement tagged with method
  implementsReq R5;
  String m1(String s) {
    return(s);
  }
}

// Requirement tagged with trait
implementsReq R4;
trait C {
  g;
}

// Requirement tagged with interface
implementsReq R6;
interface Itest {
  String m2(String s);
}
```

For more information, see the [Umple Requirements documentation](https://cruise.umple.org/umple/Requirements.html).

## How It Works

1. **Parse Requirements** - The system extracts all requirement definitions from your Umple code
2. **Select Requirements** - Choose which requirements to use:
   - **All Requirements** (default) - All requirements are used as context
   - **Select Specific Requirements** - Use checkboxes to select specific requirements to combine
3. **Select Generation Type** - Choose between state machine or class diagram generation
4. **AI Analysis** - An LLM analyzes the selected requirement text(s) and generates appropriate Umple code
5. **Review & Insert** - Review the generated code and insert it into your model

## Requirements Syntax for AI Generation

When using the AI generator, you define requirements using Umple's `req` keyword. The AI generator analyzes the requirement text and generates appropriate Umple code. You can also use `implementsReq` to tag these requirements to generated code elements.

**Basic Syntax:**
```umple
req RequirementID {
  Requirement description text goes here.
  This can span multiple lines.
}
```

**Example Requirements for AI Generation:**
```umple
req R01 {
  The system should allow users to place orders.
  Orders can be in pending, processing, shipped, delivered, or cancelled states.
  Users should be able to cancel orders only when they are pending or processing.
}

req R02 {
  The system manages customers and their orders.
  Each customer can have multiple orders.
  Each order belongs to exactly one customer.
  Orders contain items with quantity and price.
}
```

**Note:** After AI generates code, you can use `implementsReq` to link the requirement back to the generated elements:
```umple
req R01 {
  Orders can be in pending, processing, shipped, delivered, or cancelled states.
}

// AI generates this state machine
class Order {
  implementsReq R01;  // Tag the requirement to the class
  sm {
    pending { process -> processing; }
    processing { ship -> shipped; }
    shipped { deliver -> delivered; }
    delivered {}
  }
}
```

## Requirements and AI Generation

The AI Requirements Generator leverages Umple's built-in requirements feature:

1. **Define Requirements** - Use `req` to define requirement statements
2. **Select Requirements** - Choose single, multiple, or all requirements to provide context
3. **AI Generation** - The AI analyzes the selected requirement text(s) and generates Umple code
4. **Tag Requirements** - Use `implementsReq` to link requirements to generated code elements

**Multiple Requirements as Context:**
- By default, all requirements are used as context (recommended for comprehensive generation)
- You can select multiple specific requirements to combine related features
- Using multiple requirements helps the AI understand relationships and generate more integrated code
- Single requirement selection is useful for focused, specific code generation

This creates a traceable link between your requirements and the code that implements them, supporting requirement-driven development and documentation.

## Usage Instructions

### Step 1: Configure AI API Key

Before using the feature, you must configure an AI provider API key:

1. Expand the **AI** section in the left sidebar (below Tools)
2. In **AI Settings**, select your AI provider (OpenAI, Google, or OpenRouter)
3. Enter your API key
4. Click **Verify API Key**
5. Select a model from the available options

**Note**: Your API key is stored in your browser's localStorage and is never sent to the Umple server.

### Step 2: Write Requirements

Write your requirements using the `req` keyword in your Umple model:

```umple
req OrderProcessing {
  Orders move through a lifecycle: new, validated, processing, shipped, delivered.
  Only validated orders can be processed.
  Orders can be cancelled at any time before shipping.
}
```

### Step 3: Generate Code from Requirements

1. Expand the **AI** section in the left sidebar
2. Click the **"By Requirements"** button
3. A dialog will appear showing available requirements
4. **Select Requirements** - Choose which requirements to use as context:
   - **All Requirements** (default) - Uses all requirements in your model as context for better AI understanding
   - **Select Specific Requirements** - Use checkboxes to select specific requirements
   - The full requirement text(s) will be displayed for reference
5. **Choose Generation Type** - Select what to generate:
   - **State Machine** - Generates state machine syntax with states, events, and transitions
   - **Class Diagram** - Generates classes with attributes and associations
6. Click **Generate**
7. Review the generated Umple code
8. Click **Insert to Editor** to add the code to your model

**Note:** The UmpleOnline editor uses [CodeMirror 6](umpleonline/scripts/codemirror6/) for code editing. The generated code is inserted at the current cursor position in the editor.

**Note:** Using multiple requirements (or all requirements) provides the AI with more context, which can result in better, more comprehensive code generation that considers relationships between different requirements.

## Examples

### Example 1: State Machine Generation

**Requirement:**
```umple
req R01 {
  A payment transaction starts in pending state.
  After validation, it moves to processing.
  Once completed successfully, it becomes completed.
  If it fails, it moves to failed state.
  Pending transactions can be cancelled.
}
```

**Generated Umple Code (State Machine):**
```umple
class Payment {
  implementsReq R01;  // Link requirement to the class
  sm {
    pending {
      validate -> processing;
      cancel -> cancelled;
    }
    processing {
      succeed -> completed;
      fail -> failed;
    }
    completed {}
    failed {}
    cancelled {}
  }
}
```

**Note:** The `implementsReq R01;` statement links the requirement to the generated code, creating traceability between requirements and implementation.

### Example 2: Class Diagram Generation

**Requirement:**
```umple
req R02 {
  An e-commerce system has customers who place orders.
  Each customer has a name, email, and shipping address.
  Each order has an order date, total amount, and status.
  Customers can have multiple orders.
  Each order contains order items.
  Order items have product name, quantity, and unit price.
}
```

**Generated Umple Code (Class Diagram):**
```umple
class Customer {
  implementsReq R02;  // Link requirement to the class
  name;
  email;
  shippingAddress;
}

class Order {
  implementsReq R02;  // Same requirement can be tagged to multiple classes
  orderDate;
  totalAmount;
  status;
}

class OrderItem {
  implementsReq R02;
  productName;
  quantity;
  unitPrice;
}

association {
  implementsReq R02;  // Requirements can also tag associations
  1 Customer -> * Order;
}

association {
  implementsReq R02;
  1 Order -> * OrderItem;
}
```

**Note:** The same requirement can be tagged to multiple entities (classes, associations, etc.) using `implementsReq`, creating comprehensive requirement traceability.

### Example 3: Using Multiple Requirements

You can select multiple requirements (or use "All Requirements") to provide the AI with more context. This is especially useful when requirements are related:

**Multiple Requirements:**
```umple
req R01 {
  The system manages user authentication.
  Users can log in and log out.
  Sessions expire after 30 minutes of inactivity.
}

req R02 {
  Users have profiles with name, email, and role.
  Each user can have multiple sessions.
  Sessions track login time and last activity.
}

req R03 {
  The system supports three user roles: admin, manager, and regular user.
  Admins can manage all users.
  Managers can view reports.
  Regular users can only access their own data.
}
```

**Generated Umple Code (Class Diagram with Multiple Requirements):**
```umple
class User {
  implementsReq R01, R02, R03;
  name;
  email;
  role;  // admin, manager, or regular
}

class Session {
  implementsReq R01, R02;
  loginTime;
  lastActivity;
  isExpired() {
    // Check if 30 minutes have passed
  }
}

association {
  implementsReq R02;
  1 User -> * Session;
}
```

**Note:** When multiple requirements are selected, the AI can generate more comprehensive code that addresses all the selected requirements together, ensuring better integration and consistency.

## Best Practices

### For Better State Machine Generation:

1. **Be explicit about states** - Mention the states explicitly in your requirement
   - Good: "The order moves through pending, processing, shipped states"
   - Less effective: "The order has various stages"

2. **Describe transitions** - Mention events or actions that cause state changes
   - Good: "When payment is received, it transitions from pending to processing"

3. **Mention initial state** - Specify where the process starts
   - Good: "New orders start in the pending state"

4. **Include terminal states** - Mention final/completion states
   - Good: "...and finally reaches the delivered state when complete"

### For Better Class Diagram Generation:

1. **Identify entities clearly** - Name the main objects/entities
   - Good: "The system has students, courses, and enrollments"

2. **Describe attributes** - Mention key properties of entities
   - Good: "Students have a name, student ID, and email address"

3. **Specify relationships** - Be clear about associations between entities
   - Good: "Each student can enroll in multiple courses, and each course has many students"

4. **Use cardinality terms** - Use terms like "one-to-many", "each", "multiple"
   - Good: "Each department has many professors"

### For Better Results with Multiple Requirements:

1. **Use "All Requirements" by default** - This gives the AI the full context of your system
   - The AI can see relationships between requirements and generate more integrated code
   - Better for generating comprehensive class diagrams that span multiple requirements

2. **Select related requirements together** - When requirements describe related features, select them together
   - Good: Select all authentication-related requirements when generating user management classes
   - Good: Select all order-related requirements when generating e-commerce state machines

3. **Select one requirement for focused generation** - When you want to generate code for one specific feature
   - Good: Check only one requirement when generating a specific state machine
   - Good: Use a single selection when requirements are independent

4. **Combine requirements strategically** - Select requirements that complement each other
   - Good: Combine "User Management" and "Authentication" requirements for comprehensive user classes
   - Less effective: Combining unrelated requirements may confuse the AI

## Supported AI Providers

The feature supports multiple AI providers through the existing key manager:

- **OpenAI** (GPT-3.5, GPT-4, etc.)
- **Google** (Gemini models)
- **OpenRouter** (Multiple models)

## Error Handling

The system provides helpful error messages for common issues:

- **"No requirements found"** - Your Umple code doesn't contain any `req` definitions
- **"Please configure your AI API key"** - You haven't set up an AI provider yet
- **"Please select an AI model"** - You've verified your key but haven't selected a model
- **"API key verification failed"** - Your API key is invalid or expired
- **"Failed to load models"** - Couldn't fetch available models from the provider

## Troubleshooting

### AI Generation Doesn't Work

1. Verify your API key is correct and active
2. Ensure you've selected a model
3. Check that your requirements are well-formed and descriptive
4. Try a simpler requirement to test the feature
5. Check browser console for detailed error messages

### Generated Code Doesn't Compile

1. The AI may occasionally generate invalid syntax - review the code before inserting
2. Generated code may need adjustments to fit your specific model
3. Try rephrasing your requirement with more precise language
4. Consider breaking complex requirements into smaller ones

### No Requirements Detected

1. Ensure you're using the correct syntax: `req ID { description }`
2. Check that requirement IDs are alphanumeric (can include hyphens and underscores)
3. Verify requirements are not inside comments
4. Try a simple test: `req Test { This is a test requirement. }`

## Additional Resources

- [Umple Requirements Documentation](https://cruise.umple.org/umple/Requirements.html) - Complete guide to Umple's requirements feature
- [Sorting Requirements](https://cruise.umple.org/umple/SortingRequirements.html) - How to sort requirements by ID or statement

## Privacy and Security

- **API Keys**: Your AI provider API keys are stored only in your browser's localStorage
- **Data Transmission**: Requirements and generated code are sent directly to the AI provider's API
- **No Server Storage**: Umple servers never see or store your API keys
- **Network**: All API calls use HTTPS for secure communication

## Technical Implementation

The feature consists of:

- **umple_ai_requirements.js** - Main module handling UI, parsing, and AI calls
- **Prompt Engineering** - Carefully crafted prompts optimized for Umple syntax generation
- **Code Extraction** - Sophisticated parsing to extract Umple code from AI responses
- **Integration** - Leverages existing AI key manager for authentication

## Future Enhancements

Potential improvements for future versions:

- Support for generating more complex patterns (traits, mixsets, patterns)
- Batch generation from multiple requirements
- Fine-tuning prompts based on successful generations
- Integration with requirement tracing
- Support for requirement-to-test generation
- Multiple AI-generated alternatives to choose from

## License

This feature is part of Umple and is available under the same open source license: https://umple.org/license
