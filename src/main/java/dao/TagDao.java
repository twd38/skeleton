package dao;

import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.List;

import static generated.Tables.TAGS;
import static generated.Tables.RECEIPTS;

public class TagDao {
    DSLContext dsl;

    public TagDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public void toggle(String tag, int receiptId) {
        int deleted_obj = dsl.delete(TAGS).where(TAGS.TAG.eq(tag)).and(TAGS.RECEIP_ID.eq(receiptId)).execute(); // try to remove, if successful, will assign and int greater than 0. if didn't work then I need to insert a reciept into the tag


        if (deleted_obj == 0) {
            dsl
                .insertInto(TAGS, TAGS.TAG, TAGS.RECEIP_ID)
                .values(tag, receiptId)
                .execute();
        }
    }

    public List<TagsRecord> getAllTags() {
        return dsl.selectFrom(TAGS).fetch();
    }

    public List<ReceiptsRecord> getTaggedReciepts(String tag) {
        return dsl
                .select(RECEIPTS.fields())
                .from(RECEIPTS)
                .join(TAGS)
                .on(RECEIPTS.ID.eq(TAGS.RECEIP_ID))
                .where(TAGS.TAG.eq(tag))
                .fetchInto(ReceiptsRecord.class);


    }
}

//reciept records joined to tags table
