SELECT member.name
FROM member, checkout_item
WHERE member.id = checkout_item.member_id
GROUP BY checkout_item.member_id
HAVING COUNT(*) > 1;