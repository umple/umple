// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// AI Prompt Examples - Small, curated Umple snippets for few-shot grounding

const AiPromptExamples = {
  EXAMPLES: [
    {
      id: "statemachine-timed-loan",
      tags: ["statemachine", "timed", "entry", "actions"],
      title: "State machine with timed transitions",
      code: `class Loan {
  Integer deadline;

  state {
    initial {
      entry / { setDeadline(1000*60*60*24*14); }
      -> outstanding;
    }
    outstanding {
      extend -> / { setDeadline(1000*60*60*24*7); } outstanding;
      returnitem -> returned;
      after(deadline) -> overdue;
    }
    overdue {
      entry / { sendOverdueNotice(); }
      afterEvery(1000*60*60*24*2) -> overdue;
      returnitem -> returned;
    }
    returned {}
  }
}`
    },
    {
      id: "statemachine-guards-actions",
      tags: ["statemachine", "guards", "actions"],
      title: "Guards and actions on transitions",
      code: `class ItemAtAuction {
  Double reservePrice = -1.0;
  Double highestBidPrice = -1.0;

  status {
    listed {
      entry / { highestBidPrice = reservePrice; }
      openBidding [highestBidPrice >= reservePrice] -> openForBidding;
    }
    openForBidding {
      bid(double amount) [amount > highestBidPrice] / { highestBidPrice = amount; } -> openForBidding;
      closeBids [highestBidPrice == reservePrice] -> withdrawn;
      closeBids [highestBidPrice > reservePrice] -> sold;
    }
    withdrawn {}
    sold {}
  }
}`
    },
    {
      id: "classdiagram-attributes-associations",
      tags: ["classdiagram", "attributes", "associations", "multiplicity"],
      title: "Classes with attributes and associations",
      code: `class Customer {
  name;
  email;
}

class Order {
  orderDate;
  totalAmount;
}

association {
  1 Customer -> * Order;
}`
    }
  ],

  getExamplesByTags(tags = [], limit = 2) {
    const wanted = new Set((tags || []).filter(Boolean));
    if (wanted.size === 0) return [];

    const scored = this.EXAMPLES
      .map(ex => {
        const exTags = new Set(ex.tags || []);
        let score = 0;
        wanted.forEach(t => {
          if (exTags.has(t)) score += 1;
        });
        return { ex, score };
      })
      .filter(x => x.score > 0)
      .sort((a, b) => b.score - a.score);

    return scored.slice(0, limit).map(x => x.ex);
  }
};
