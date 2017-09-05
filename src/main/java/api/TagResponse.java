package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import generated.tables.records.TagsRecord;
import generated.tables.records.ReceiptsRecord;


public class TagResponse {
    @JsonProperty
    Integer id;

    @JsonProperty
    String tag;

    @JsonProperty
    Integer receiptId;

    @JsonProperty
    String merchantName;

    public TagResponse(TagsRecord dbRecord) {
        this.tag = dbRecord.getTag();
        this.receiptId = dbRecord.getReceipId();
        this.id = dbRecord.getTid();
    }

}
