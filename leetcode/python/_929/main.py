from typing import List

class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        uniqs = set()

        for email in emails:
            splits = email.split('@')
            local, domain = splits[0], splits[1]
            local = local.split('+')[0].replace('.', '')
            uniqs.add(local + '@' + domain)

        return len(uniqs)

print(Solution().numUniqueEmails(["test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"]))